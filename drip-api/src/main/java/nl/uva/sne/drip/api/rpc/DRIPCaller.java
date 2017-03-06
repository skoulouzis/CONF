package nl.uva.sne.drip.api.rpc;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import nl.uva.sne.drip.commons.types.Message;
import nl.uva.sne.drip.commons.types.MessageParameter;
import nl.uva.sne.drip.commons.utils.Converter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/*
 * Copyright 2017 S. Koulouzis, Wang Junchao, Huan Zhou, Yang Hu 
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 *
 * @author S. Koulouzis
 */
public abstract class DRIPCaller implements AutoCloseable {

    private final Connection connection;
    private final Channel channel;
    private final String replyQueueName;
    private final String requestQeueName;
    private final ObjectMapper mapper;

    public DRIPCaller(String messageBrokerHost, String requestQeueName) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(messageBrokerHost);
        factory.setPort(AMQP.PROTOCOL.PORT);
        //factory.setUsername("guest");
        //factory.setPassword("pass");

        connection = factory.newConnection();
        channel = connection.createChannel();
        // create a single callback queue per client not per requests. 
        replyQueueName = channel.queueDeclare().getQueue();
        this.requestQeueName = requestQeueName;
        this.mapper = new ObjectMapper();
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
    }

    /**
     * @return the connection
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * @return the channel
     */
    public Channel getChannel() {
        return channel;
    }

    /**
     * @return the replyQueueName
     */
    public String getReplyQueueName() {
        return replyQueueName;
    }

    @Override
    public void close() throws IOException, TimeoutException {
        if (channel != null && channel.isOpen()) {
            channel.close();
        }
        if (connection != null && connection.isOpen()) {
            connection.close();
        }
    }

    public Message call(Message r) throws IOException, TimeoutException, InterruptedException, JSONException {

        String jsonInString = mapper.writeValueAsString(r);

        //Build a correlation ID to distinguish responds 
        final String corrId = UUID.randomUUID().toString();
        AMQP.BasicProperties props = new AMQP.BasicProperties.Builder()
                .correlationId(corrId)
                .replyTo(getReplyQueueName())
                .build();

        getChannel().basicPublish("", requestQeueName, props, jsonInString.getBytes("UTF-8"));

        final BlockingQueue<String> response = new ArrayBlockingQueue(1);

        getChannel().basicConsume(getReplyQueueName(), true, new DefaultConsumer(getChannel()) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                if (properties.getCorrelationId().equals(corrId)) {
                    response.offer(new String(body, "UTF-8"));
                }
            }
        });
        String resp = response.take();
        String clean = resp.replaceAll("'null'", "null").replaceAll("\'", "\"").replaceAll(" ", "");

        if (clean.contains("\"value\":{\"")) {
            return Converter.string2Message(clean);
        }
        Logger.getLogger(DRIPCaller.class.getName()).log(Level.INFO, "Got: {0}", clean);
        return mapper.readValue(clean, Message.class);
    }

    private Message unMarshallWithSimpleJson(String strResponse) throws JSONException {
        strResponse = strResponse.replaceAll("'null'", "null").replaceAll("\'", "\"").replaceAll(" ", "");
//        System.err.println(strResponse);
        JSONObject jsonObj = new JSONObject(strResponse);
        Message responseMessage = new Message();
        responseMessage.setCreationDate((Long) jsonObj.get("creationDate"));
        JSONArray jsonParams = (JSONArray) jsonObj.get("parameters");
        List<MessageParameter> parameters = new ArrayList<>();

        for (int i = 0; i < jsonParams.length(); i++) {
            JSONObject jsonParam = (JSONObject) jsonParams.get(i);

            MessageParameter parameter = new MessageParameter();
            parameter.setName(jsonParam.getString("name"));
            parameter.setValue(jsonParam.getString("value"));
            parameters.add(parameter);
        }

        responseMessage.setParameters(parameters);
        return responseMessage;//

    }

//    public Message unmarshall(String strResponse) throws IOException {
//
//        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
//        strResponse = strResponse.replaceAll("'null'", "null").replaceAll("\'", "\"").replaceAll(" ", "");
////        return unMarshallWithSimpleJson(strResponse);
//        return mapper.readValue(strResponse, Message.class);
//    }
}

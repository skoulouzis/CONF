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
package nl.uva.sne.drip.api.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import nl.uva.sne.drip.api.dao.ToscaDao;
import nl.uva.sne.drip.api.exception.NotFoundException;
import nl.uva.sne.drip.commons.v1.types.ToscaRepresentation;
import nl.uva.sne.drip.commons.utils.Converter;
import nl.uva.sne.drip.commons.v1.types.User;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author S. Koulouzis
 */
@Service
@PreAuthorize("isAuthenticated()")
public class ToscaService {

    private static final int[] BAD_CHARS = {0x80};

    @Autowired
    private ToscaDao dao;

    public String get(String id, String fromat) throws JSONException {
        ToscaRepresentation tosca = findOne(id);
        if (tosca == null) {
            throw new NotFoundException();
        }

        Map<String, Object> map = tosca.getKeyValue();

        if (fromat != null && fromat.equals("yml")) {
            String ymlStr = Converter.map2YmlString(map);
            ymlStr = ymlStr.replaceAll("\\uff0E", "\\.");
            return ymlStr;
        }
        if (fromat != null && fromat.equals("json")) {
            String jsonStr = Converter.map2JsonString(map);
            jsonStr = jsonStr.replaceAll("\\uff0E", "\\.");
            return jsonStr;
        }
        String ymlStr = Converter.map2YmlString(map);
        ymlStr = ymlStr.replaceAll("\\uff0E", "\\.");
        return ymlStr;
    }

    public String saveFile(MultipartFile file) throws IOException {
        String originalFileName = file.getOriginalFilename();
        String name = System.currentTimeMillis() + "_" + originalFileName;
        byte[] bytes = file.getBytes();
        String str = new String(bytes, "UTF-8");
        return saveStringContents(str, name);
    }

    public String saveYamlString(String yamlString, String name) throws IOException {
        if (name == null) {
            name = System.currentTimeMillis() + "_" + "tosca.yaml";
        }
        yamlString = yamlString.replaceAll("\\.", "\uff0E");
        Map<String, Object> map = Converter.ymlString2Map(yamlString);
        ToscaRepresentation t = new ToscaRepresentation();
        t.setName(name);
        t.setKvMap(map);
        save(t);
        return t.getId();
    }

    @PostAuthorize("(returnObject.owner == authentication.name) or (hasRole('ROLE_ADMIN'))")
    public ToscaRepresentation delete(String id) {
        ToscaRepresentation tr = dao.findOne(id);
        dao.delete(tr);
        return tr;
    }

    @PostFilter("(filterObject.owner == authentication.name) or (hasRole('ROLE_ADMIN'))")
    public List<ToscaRepresentation> findAll() {
        return dao.findAll();
    }

    @PostAuthorize("(returnObject.owner == authentication.name) or (hasRole('ROLE_ADMIN'))")
    public ToscaRepresentation findOne(String id) {
        return dao.findOne(id);
    }

    private ToscaRepresentation save(ToscaRepresentation t) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String owner = user.getUsername();
        t.setOwner(owner);
        return dao.save(t);
    }

    @PostAuthorize("(hasRole('ROLE_ADMIN'))")
    public void deleteAll() {
        dao.deleteAll();
    }

    public String saveStringContents(String toscaContents, String name) throws IOException {

        //Remove '\' and 'n' if they are together and replace them with '\n'
        char[] array = toscaContents.toCharArray();
        StringBuilder sb = new StringBuilder();
        int prevChar = -1;
        for (int i = 0; i < array.length; i++) {
            int currentChar = (int) array[i];
            if (prevChar > 0 && prevChar == 92 && currentChar == 110) {
                sb.delete(sb.length() - 1, sb.length());
                sb.append('\n');

            } else {
                sb.append((char) currentChar);
            }
            prevChar = (int) array[i];
        }
        toscaContents = sb.toString();
        toscaContents = toscaContents.replaceAll("(?m)^[ \t]*\r?\n", "");
        for (int i = 0; i < BAD_CHARS.length; i++) {
            int hex = BAD_CHARS[i];
            toscaContents = toscaContents.replaceAll(String.valueOf((char) hex), "");
        }

        toscaContents = toscaContents.replaceAll("\\.", "\uff0E");
        Map<String, Object> map = Converter.ymlString2Map(toscaContents);
        ToscaRepresentation t = new ToscaRepresentation();
        t.setName(name);
        t.setKvMap(map);
        save(t);
        return t.getId();
    }

}

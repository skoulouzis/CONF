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
package nl.uva.sne.drip.drip.commons.data.v1.external;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.webcohesion.enunciate.metadata.DocumentationExample;

/**
 *
 * This class is used by the deployer to deploy software
 * (swarm,kubernetes,ansible). It is generated by the provisioner to contain VM
 * information.
 *
 * @author S. Koulouzis
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeployParameter {

//    private String cloudCertificateName;

    private String IP;

    private String user;
    private String role;

//    /**
//     * The file name of the certificate used to log in as root to the 
//     * provisioned VM.
//     * @return the cloudCertificateName
//     */
//    @DocumentationExample("Virginia")
//    public String getCloudCertificateName() {
//        return cloudCertificateName;
//    }
//
//    /**
//     * @param cloudCertificateName the cloudCertificateName to set
//     */
//    public void setCloudCertificateName(String cloudCertificateName) {
//        this.cloudCertificateName = cloudCertificateName;
//    }

    /**
     * The public IP of the provisioned VM
     * @return the IP
     */
    @DocumentationExample("52.73.245.157")
    public String getIP() {
        return IP;
    }

    /**
     * @param IP the IP to set
     */
    public void setIP(String IP) {
        this.IP = IP;
    }

    /**
     * The user name of the account created on the provisioned VM 
     * @return the user
     */
    @DocumentationExample("vm_user")
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * The role of the provisioned VM 
     * @return the role
     */
    @DocumentationExample("slave")
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

}

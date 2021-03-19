/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.10).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package nl.uva.sne.drip.api;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import nl.uva.qcdis.sdia.model.tosca.Credential;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-06T13:31:49.386Z")

@Api(value = "credential", description = "the credential API")
public interface CredentialApi {

    @ApiOperation(value = "Create credentials", nickname = "createCredentials", notes = "Creates credentials", response = String.class, authorizations = {
        @Authorization(value = "auth", scopes = {
            @AuthorizationScope(scope = "read:Credentials", description = "read your cloud credentials")
            ,
            @AuthorizationScope(scope = "write:Credentials", description = "modify cloud credentials in your account")
        })
    }, tags = {})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "successful operation", response = String.class)
        ,
        @ApiResponse(code = 400, message = "Invalid ID supplied")
        ,
        @ApiResponse(code = 404, message = "ToscaTemplate not found")
        ,
        @ApiResponse(code = 405, message = "Invalid input")})
    @RequestMapping(value = "/manager/credential",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<String> createCredentials(@ApiParam(value = "Created user object", required = true) @Valid @RequestBody Credential body);

    @ApiOperation(value = "Get all credential IDs", nickname = "getCredentialIDs", notes = "Returns all IDss ", response = String.class, responseContainer = "List", authorizations = {
        @Authorization(value = "auth", scopes = {
            @AuthorizationScope(scope = "read:ToscaTemplate", description = "read your topolog template")
            ,
            @AuthorizationScope(scope = "write:ToscaTemplate", description = "modify topolog template in your account")
        })
    }, tags = {})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "successful operation", response = String.class, responseContainer = "List")
        ,
        @ApiResponse(code = 400, message = "Invalid ID supplied")
        ,
        @ApiResponse(code = 404, message = "ToscaTemplate not found")
        ,
        @ApiResponse(code = 405, message = "Invalid input")})
    @RequestMapping(value = "/manager/credential/ids",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<String>> getCredentialIDs();

}

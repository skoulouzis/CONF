package nl.uva.sne.drip.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import org.springframework.data.annotation.Id;

/**
 * ToscaTemplate
 */
@Validated
@JsonInclude(Include.NON_NULL)
public class ToscaTemplate {

    @Id
    @JsonIgnore
    private String id;

    @JsonProperty("tosca_definitions_version")
    private String toscaDefinitionsVersion = null;

    @JsonProperty("tosca_default_namespace")
    private String toscaDefaultNamespace = null;

    @JsonProperty("template_name")
    private String templateName = null;

    @JsonProperty("imports")
    @Valid
    private List<Map<String, String>> imports = null;

    @JsonProperty("repositories")
    @Valid
    private Map<String, String> repositories = null;

    @JsonProperty("dsl_definitions")
    @Valid
    private Map<String, String> dslDefinitions = null;

    @JsonProperty("node_types")
    @Valid
    private Map<String, Object> nodeTypes = null;

    @JsonProperty("topology_template")
    private TopologyTemplate topologyTemplate = null;

    @JsonProperty("relationship_types")
    @Valid
    private Map<String, Object> relationshipTypes = null;

    @JsonProperty("relationship_templates")
    @Valid
    private Map<String, Object> relationshipTemplates = null;

    @JsonProperty("capability_types")
    @Valid
    private Map<String, Object> capabilityTypes = null;

    @JsonProperty("artifact_types")
    @Valid
    private Map<String, Object> artifactTypes = null;

    @JsonProperty("data_types")
    @Valid
    private Map<String, Object> dataTypes = null;

    @JsonProperty("interface_types")
    @Valid
    private Map<String, Object> interfaceTypes = null;

    @JsonProperty("policy_types")
    @Valid
    private Map<String, String> policyTypes = null;

    @JsonProperty("group_types")
    @Valid
    private Map<String, Object> groupTypes = null;

    @JsonProperty("description")
    private String description = null;

    @JsonProperty("template_author")
    private String templateAuthor = null;

    public ToscaTemplate toscaDefinitionsVersion(String toscaDefinitionsVersion) {
        this.toscaDefinitionsVersion = toscaDefinitionsVersion;
        return this;
    }

    @JsonIgnore
    public String getId() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    /**
     * Get toscaDefinitionsVersion
     *
     * @return toscaDefinitionsVersion
     *
     */
    @ApiModelProperty(value = "")

    public String getToscaDefinitionsVersion() {
        return toscaDefinitionsVersion;
    }

    public void setToscaDefinitionsVersion(String toscaDefinitionsVersion) {
        this.toscaDefinitionsVersion = toscaDefinitionsVersion;
    }

    public ToscaTemplate toscaDefaultNamespace(String toscaDefaultNamespace) {
        this.toscaDefaultNamespace = toscaDefaultNamespace;
        return this;
    }

    /**
     * Get toscaDefaultNamespace
     *
     * @return toscaDefaultNamespace
     *
     */
    @ApiModelProperty(value = "")

    public String getToscaDefaultNamespace() {
        return toscaDefaultNamespace;
    }

    public void setToscaDefaultNamespace(String toscaDefaultNamespace) {
        this.toscaDefaultNamespace = toscaDefaultNamespace;
    }

    public ToscaTemplate templateName(String templateName) {
        this.templateName = templateName;
        return this;
    }

    /**
     * Get templateName
     *
     * @return templateName
     *
     */
    @ApiModelProperty(value = "")

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public ToscaTemplate imports(List<Map<String, String>> imports) {
        this.imports = imports;
        return this;
    }

    public ToscaTemplate addImportsItem(Map<String, String> importsItem) {
        if (this.imports == null) {
            this.imports = new ArrayList<>();
        }
        this.imports.add(importsItem);
        return this;
    }

    /**
     * Get imports
     *
     * @return imports
     *
     */
    @ApiModelProperty(value = "")

    @Valid

    public List<Map<String, String>> getImports() {
        return imports;
    }

    public void setImports(List<Map<String, String>> imports) {
        this.imports = imports;
    }

    public ToscaTemplate repositories(Map<String, String> repositories) {
        this.repositories = repositories;
        return this;
    }

    public ToscaTemplate putRepositoriesItem(String key, String repositoriesItem) {
        if (this.repositories == null) {
            this.repositories = new HashMap<>();
        }
        this.repositories.put(key, repositoriesItem);
        return this;
    }

    /**
     * Get repositories
     *
     * @return repositories
     *
     */
    @ApiModelProperty(value = "")

    public Map<String, String> getRepositories() {
        return repositories;
    }

    public void setRepositories(Map<String, String> repositories) {
        this.repositories = repositories;
    }

    public ToscaTemplate dslDefinitions(Map<String, String> dslDefinitions) {
        this.dslDefinitions = dslDefinitions;
        return this;
    }

    public ToscaTemplate putDslDefinitionsItem(String key, String dslDefinitionsItem) {
        if (this.dslDefinitions == null) {
            this.dslDefinitions = new HashMap<>();
        }
        this.dslDefinitions.put(key, dslDefinitionsItem);
        return this;
    }

    /**
     * Get dslDefinitions
     *
     * @return dslDefinitions
     *
     */
    @ApiModelProperty(value = "")

    public Map<String, String> getDslDefinitions() {
        return dslDefinitions;
    }

    public void setDslDefinitions(Map<String, String> dslDefinitions) {
        this.dslDefinitions = dslDefinitions;
    }

    public ToscaTemplate nodeTypes(Map<String, Object> nodeTypes) {
        this.nodeTypes = nodeTypes;
        return this;
    }

    public ToscaTemplate putNodeTypesItem(String key, Object nodeTypesItem) {
        if (this.nodeTypes == null) {
            this.nodeTypes = new HashMap<>();
        }
        this.nodeTypes.put(key, nodeTypesItem);
        return this;
    }

    /**
     * Get nodeTypes
     *
     * @return nodeTypes
     *
     */
    @ApiModelProperty(value = "")

    public Map<String, Object> getNodeTypes() {
        return nodeTypes;
    }

    public void setNodeTypes(Map<String, Object> nodeTypes) {
        this.nodeTypes = nodeTypes;
    }

    public ToscaTemplate topologyTemplate(TopologyTemplate topologyTemplate) {
        this.topologyTemplate = topologyTemplate;
        return this;
    }

    /**
     * Get topologyTemplate
     *
     * @return topologyTemplate
     *
     */
    @ApiModelProperty(value = "")

    @Valid

    public TopologyTemplate getTopologyTemplate() {
        return topologyTemplate;
    }

    public void setTopologyTemplate(TopologyTemplate topologyTemplate) {
        this.topologyTemplate = topologyTemplate;
    }

    public ToscaTemplate relationshipTypes(Map<String, Object> relationshipTypes) {
        this.relationshipTypes = relationshipTypes;
        return this;
    }

    public ToscaTemplate putRelationshipTypesItem(String key, Object relationshipTypesItem) {
        if (this.relationshipTypes == null) {
            this.relationshipTypes = new HashMap<>();
        }
        this.relationshipTypes.put(key, relationshipTypesItem);
        return this;
    }

    /**
     * Get relationshipTypes
     *
     * @return relationshipTypes
     *
     */
    @ApiModelProperty(value = "")

    public Map<String, Object> getRelationshipTypes() {
        return relationshipTypes;
    }

    public void setRelationshipTypes(Map<String, Object> relationshipTypes) {
        this.relationshipTypes = relationshipTypes;
    }

    public ToscaTemplate relationshipTemplates(Map<String, Object> relationshipTemplates) {
        this.relationshipTemplates = relationshipTemplates;
        return this;
    }

    public ToscaTemplate putRelationshipTemplatesItem(String key, Object relationshipTemplatesItem) {
        if (this.relationshipTemplates == null) {
            this.relationshipTemplates = new HashMap<>();
        }
        this.relationshipTemplates.put(key, relationshipTemplatesItem);
        return this;
    }

    /**
     * Get relationshipTemplates
     *
     * @return relationshipTemplates
     *
     */
    @ApiModelProperty(value = "")

    public Map<String, Object> getRelationshipTemplates() {
        return relationshipTemplates;
    }

    public void setRelationshipTemplates(Map<String, Object> relationshipTemplates) {
        this.relationshipTemplates = relationshipTemplates;
    }

    public ToscaTemplate capabilityTypes(Map<String, Object> capabilityTypes) {
        this.capabilityTypes = capabilityTypes;
        return this;
    }

    public ToscaTemplate putCapabilityTypesItem(String key, Object capabilityTypesItem) {
        if (this.capabilityTypes == null) {
            this.capabilityTypes = new HashMap<>();
        }
        this.capabilityTypes.put(key, capabilityTypesItem);
        return this;
    }

    /**
     * Get capabilityTypes
     *
     * @return capabilityTypes
     *
     */
    @ApiModelProperty(value = "")

    public Map<String, Object> getCapabilityTypes() {
        return capabilityTypes;
    }

    public void setCapabilityTypes(Map<String, Object> capabilityTypes) {
        this.capabilityTypes = capabilityTypes;
    }

    public ToscaTemplate artifactTypes(Map<String, Object> artifactTypes) {
        this.artifactTypes = artifactTypes;
        return this;
    }

    public ToscaTemplate putArtifactTypesItem(String key, Object artifactTypesItem) {
        if (this.artifactTypes == null) {
            this.artifactTypes = new HashMap<>();
        }
        this.artifactTypes.put(key, artifactTypesItem);
        return this;
    }

    /**
     * Get artifactTypes
     *
     * @return artifactTypes
     *
     */
    @ApiModelProperty(value = "")

    public Map<String, Object> getArtifactTypes() {
        return artifactTypes;
    }

    public void setArtifactTypes(Map<String, Object> artifactTypes) {
        this.artifactTypes = artifactTypes;
    }

    public ToscaTemplate dataTypes(Map<String, Object> dataTypes) {
        this.dataTypes = dataTypes;
        return this;
    }

    public ToscaTemplate putDataTypesItem(String key, Object dataTypesItem) {
        if (this.dataTypes == null) {
            this.dataTypes = new HashMap<>();
        }
        this.dataTypes.put(key, dataTypesItem);
        return this;
    }

    /**
     * Get dataTypes
     *
     * @return dataTypes
     *
     */
    @ApiModelProperty(value = "")

    public Map<String, Object> getDataTypes() {
        return dataTypes;
    }

    public void setDataTypes(Map<String, Object> dataTypes) {
        this.dataTypes = dataTypes;
    }

    public ToscaTemplate interfaceTypes(Map<String, Object> interfaceTypes) {
        this.interfaceTypes = interfaceTypes;
        return this;
    }

    public ToscaTemplate putInterfaceTypesItem(String key, Object interfaceTypesItem) {
        if (this.interfaceTypes == null) {
            this.interfaceTypes = new HashMap<>();
        }
        this.interfaceTypes.put(key, interfaceTypesItem);
        return this;
    }

    /**
     * Get interfaceTypes
     *
     * @return interfaceTypes
     *
     */
    @ApiModelProperty(value = "")

    public Map<String, Object> getInterfaceTypes() {
        return interfaceTypes;
    }

    public void setInterfaceTypes(Map<String, Object> interfaceTypes) {
        this.interfaceTypes = interfaceTypes;
    }

    public ToscaTemplate policyTypes(Map<String, String> policyTypes) {
        this.policyTypes = policyTypes;
        return this;
    }

    public ToscaTemplate putPolicyTypesItem(String key, String policyTypesItem) {
        if (this.policyTypes == null) {
            this.policyTypes = new HashMap<>();
        }
        this.policyTypes.put(key, policyTypesItem);
        return this;
    }

    /**
     * Get policyTypes
     *
     * @return policyTypes
     *
     */
    @ApiModelProperty(value = "")

    public Map<String, String> getPolicyTypes() {
        return policyTypes;
    }

    public void setPolicyTypes(Map<String, String> policyTypes) {
        this.policyTypes = policyTypes;
    }

    public ToscaTemplate groupTypes(Map<String, Object> groupTypes) {
        this.groupTypes = groupTypes;
        return this;
    }

    public ToscaTemplate putGroupTypesItem(String key, Object groupTypesItem) {
        if (this.groupTypes == null) {
            this.groupTypes = new HashMap<>();
        }
        this.groupTypes.put(key, groupTypesItem);
        return this;
    }

    /**
     * Get groupTypes
     *
     * @return groupTypes
     *
     */
    @ApiModelProperty(value = "")

    public Map<String, Object> getGroupTypes() {
        return groupTypes;
    }

    public void setGroupTypes(Map<String, Object> groupTypes) {
        this.groupTypes = groupTypes;
    }

    public ToscaTemplate description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get description
     *
     * @return description
     *
     */
    @ApiModelProperty(value = "")

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ToscaTemplate templateAuthor(String templateAuthor) {
        this.templateAuthor = templateAuthor;
        return this;
    }

    /**
     * Get templateAuthor
     *
     * @return templateAuthor
     *
     */
    @ApiModelProperty(value = "")

    public String getTemplateAuthor() {
        return templateAuthor;
    }

    public void setTemplateAuthor(String templateAuthor) {
        this.templateAuthor = templateAuthor;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ToscaTemplate toscaTemplate = (ToscaTemplate) o;
        return Objects.equals(this.toscaDefinitionsVersion, toscaTemplate.toscaDefinitionsVersion)
                && Objects.equals(this.toscaDefaultNamespace, toscaTemplate.toscaDefaultNamespace)
                && Objects.equals(this.templateName, toscaTemplate.templateName)
                && Objects.equals(this.imports, toscaTemplate.imports)
                && Objects.equals(this.repositories, toscaTemplate.repositories)
                && Objects.equals(this.dslDefinitions, toscaTemplate.dslDefinitions)
                && Objects.equals(this.nodeTypes, toscaTemplate.nodeTypes)
                && Objects.equals(this.topologyTemplate, toscaTemplate.topologyTemplate)
                && Objects.equals(this.relationshipTypes, toscaTemplate.relationshipTypes)
                && Objects.equals(this.relationshipTemplates, toscaTemplate.relationshipTemplates)
                && Objects.equals(this.capabilityTypes, toscaTemplate.capabilityTypes)
                && Objects.equals(this.artifactTypes, toscaTemplate.artifactTypes)
                && Objects.equals(this.dataTypes, toscaTemplate.dataTypes)
                && Objects.equals(this.interfaceTypes, toscaTemplate.interfaceTypes)
                && Objects.equals(this.policyTypes, toscaTemplate.policyTypes)
                && Objects.equals(this.groupTypes, toscaTemplate.groupTypes)
                && Objects.equals(this.description, toscaTemplate.description)
                && Objects.equals(this.templateAuthor, toscaTemplate.templateAuthor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(toscaDefinitionsVersion, toscaDefaultNamespace, templateName, imports, repositories, dslDefinitions, nodeTypes, topologyTemplate, relationshipTypes, relationshipTemplates, capabilityTypes, artifactTypes, dataTypes, interfaceTypes, policyTypes, groupTypes, description, templateAuthor);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ToscaTemplate {\n");

        sb.append("    toscaDefinitionsVersion: ").append(toIndentedString(toscaDefinitionsVersion)).append("\n");
        sb.append("    toscaDefaultNamespace: ").append(toIndentedString(toscaDefaultNamespace)).append("\n");
        sb.append("    templateName: ").append(toIndentedString(templateName)).append("\n");
        sb.append("    imports: ").append(toIndentedString(imports)).append("\n");
        sb.append("    repositories: ").append(toIndentedString(repositories)).append("\n");
        sb.append("    dslDefinitions: ").append(toIndentedString(dslDefinitions)).append("\n");
        sb.append("    nodeTypes: ").append(toIndentedString(nodeTypes)).append("\n");
        sb.append("    topologyTemplate: ").append(toIndentedString(topologyTemplate)).append("\n");
        sb.append("    relationshipTypes: ").append(toIndentedString(relationshipTypes)).append("\n");
        sb.append("    relationshipTemplates: ").append(toIndentedString(relationshipTemplates)).append("\n");
        sb.append("    capabilityTypes: ").append(toIndentedString(capabilityTypes)).append("\n");
        sb.append("    artifactTypes: ").append(toIndentedString(artifactTypes)).append("\n");
        sb.append("    dataTypes: ").append(toIndentedString(dataTypes)).append("\n");
        sb.append("    interfaceTypes: ").append(toIndentedString(interfaceTypes)).append("\n");
        sb.append("    policyTypes: ").append(toIndentedString(policyTypes)).append("\n");
        sb.append("    groupTypes: ").append(toIndentedString(groupTypes)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    templateAuthor: ").append(toIndentedString(templateAuthor)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

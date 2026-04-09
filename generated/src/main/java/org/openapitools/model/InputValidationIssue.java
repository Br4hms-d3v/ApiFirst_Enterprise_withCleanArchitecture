package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.net.URI;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * An issue detected during input validation.  &#x60;status&#x60; is usually not present. &#x60;href&#x60;, if present, refers to documentation of the issue type. Additional properties specific to the issue type may be present. 
 */

@Schema(name = "InputValidationIssue", description = "An issue detected during input validation.  `status` is usually not present. `href`, if present, refers to documentation of the issue type. Additional properties specific to the issue type may be present. ")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-04-09T23:16:15.131429100+02:00[Europe/Brussels]", comments = "Generator version: 7.4.0")
public class InputValidationIssue {

  /**
   * The location of the invalid input
   */
  public enum InEnum {
    BODY("body"),
    
    HEADER("header"),
    
    PATH("path"),
    
    QUERY("query");

    private String value;

    InEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static InEnum fromValue(String value) {
      for (InEnum b : InEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private InEnum in;

  private String name;

  private Object value = null;

  private URI type = URI.create("about:blank");

  private URI href;

  private String title;

  private Integer status;

  private String detail;

  private URI instance;

  public InputValidationIssue in(InEnum in) {
    this.in = in;
    return this;
  }

  /**
   * The location of the invalid input
   * @return in
  */
  
  @Schema(name = "in", description = "The location of the invalid input", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("in")
  public InEnum getIn() {
    return in;
  }

  public void setIn(InEnum in) {
    this.in = in;
  }

  public InputValidationIssue name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of the invalid input
   * @return name
  */
  
  @Schema(name = "name", description = "The name of the invalid input", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public InputValidationIssue value(Object value) {
    this.value = value;
    return this;
  }

  /**
   * The value of the erroneous input
   * @return value
  */
  
  @Schema(name = "value", description = "The value of the erroneous input", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("value")
  public Object getValue() {
    return value;
  }

  public void setValue(Object value) {
    this.value = value;
  }

  public InputValidationIssue type(URI type) {
    this.type = type;
    return this;
  }

  /**
   * An absolute URI that identifies the problem type
   * @return type
  */
  @Valid 
  @Schema(name = "type", description = "An absolute URI that identifies the problem type", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("type")
  public URI getType() {
    return type;
  }

  public void setType(URI type) {
    this.type = type;
  }

  public InputValidationIssue href(URI href) {
    this.href = href;
    return this;
  }

  /**
   * An absolute URI that, when dereferenced, provides human-readable documentation for the problem type (e.g. using HTML)
   * @return href
  */
  @Valid 
  @Schema(name = "href", description = "An absolute URI that, when dereferenced, provides human-readable documentation for the problem type (e.g. using HTML)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("href")
  public URI getHref() {
    return href;
  }

  public void setHref(URI href) {
    this.href = href;
  }

  public InputValidationIssue title(String title) {
    this.title = title;
    return this;
  }

  /**
   * A short summary of the problem type; Written in English and readable for engineers (usually not suited for non technical stakeholders and not localized),
   * @return title
  */
  
  @Schema(name = "title", example = "Service Unavailable", description = "A short summary of the problem type; Written in English and readable for engineers (usually not suited for non technical stakeholders and not localized),", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public InputValidationIssue status(Integer status) {
    this.status = status;
    return this;
  }

  /**
   * The Http status code generated by the origin server for this occurrence of the problem
   * minimum: 400
   * maximum: 600
   * @return status
  */
  @Min(400) @Max(600) 
  @Schema(name = "status", example = "503", description = "The Http status code generated by the origin server for this occurrence of the problem", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status")
  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public InputValidationIssue detail(String detail) {
    this.detail = detail;
    return this;
  }

  /**
   * A human-readable explanation specific to this occurrence of the problem
   * @return detail
  */
  
  @Schema(name = "detail", description = "A human-readable explanation specific to this occurrence of the problem", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("detail")
  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  public InputValidationIssue instance(URI instance) {
    this.instance = instance;
    return this;
  }

  /**
   * An absolute URI that identifies the specific occurrence of the problem. it may or may not yield further information if dereferenced
   * @return instance
  */
  @Valid 
  @Schema(name = "instance", description = "An absolute URI that identifies the specific occurrence of the problem. it may or may not yield further information if dereferenced", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("instance")
  public URI getInstance() {
    return instance;
  }

  public void setInstance(URI instance) {
    this.instance = instance;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InputValidationIssue inputValidationIssue = (InputValidationIssue) o;
    return Objects.equals(this.in, inputValidationIssue.in) &&
        Objects.equals(this.name, inputValidationIssue.name) &&
        Objects.equals(this.value, inputValidationIssue.value) &&
        Objects.equals(this.type, inputValidationIssue.type) &&
        Objects.equals(this.href, inputValidationIssue.href) &&
        Objects.equals(this.title, inputValidationIssue.title) &&
        Objects.equals(this.status, inputValidationIssue.status) &&
        Objects.equals(this.detail, inputValidationIssue.detail) &&
        Objects.equals(this.instance, inputValidationIssue.instance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(in, name, value, type, href, title, status, detail, instance);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InputValidationIssue {\n");
    sb.append("    in: ").append(toIndentedString(in)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
    sb.append("    instance: ").append(toIndentedString(instance)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}


package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * UpdateEmployeeRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-04-09T23:16:15.131429100+02:00[Europe/Brussels]", comments = "Generator version: 7.4.0")
public class UpdateEmployeeRequest {

  private Long id;

  private String name;

  private String firstname;

  private String service;

  private Integer floor;

  public UpdateEmployeeRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public UpdateEmployeeRequest(Long id) {
    this.id = id;
  }

  public UpdateEmployeeRequest id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @NotNull 
  @Schema(name = "id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public UpdateEmployeeRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  
  @Schema(name = "name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UpdateEmployeeRequest firstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  /**
   * Get firstname
   * @return firstname
  */
  
  @Schema(name = "firstname", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("firstname")
  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public UpdateEmployeeRequest service(String service) {
    this.service = service;
    return this;
  }

  /**
   * Get service
   * @return service
  */
  
  @Schema(name = "service", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("service")
  public String getService() {
    return service;
  }

  public void setService(String service) {
    this.service = service;
  }

  public UpdateEmployeeRequest floor(Integer floor) {
    this.floor = floor;
    return this;
  }

  /**
   * Get floor
   * @return floor
  */
  
  @Schema(name = "floor", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("floor")
  public Integer getFloor() {
    return floor;
  }

  public void setFloor(Integer floor) {
    this.floor = floor;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateEmployeeRequest updateEmployeeRequest = (UpdateEmployeeRequest) o;
    return Objects.equals(this.id, updateEmployeeRequest.id) &&
        Objects.equals(this.name, updateEmployeeRequest.name) &&
        Objects.equals(this.firstname, updateEmployeeRequest.firstname) &&
        Objects.equals(this.service, updateEmployeeRequest.service) &&
        Objects.equals(this.floor, updateEmployeeRequest.floor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, firstname, service, floor);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateEmployeeRequest {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    firstname: ").append(toIndentedString(firstname)).append("\n");
    sb.append("    service: ").append(toIndentedString(service)).append("\n");
    sb.append("    floor: ").append(toIndentedString(floor)).append("\n");
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


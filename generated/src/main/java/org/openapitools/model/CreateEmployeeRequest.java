package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.model.Address;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CreateEmployeeRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-04-09T23:16:15.131429100+02:00[Europe/Brussels]", comments = "Generator version: 7.4.0")
public class CreateEmployeeRequest {

  private String name;

  private String firstname;

  private String service;

  private Integer floor;

  private String email;

  private Address address;

  public CreateEmployeeRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CreateEmployeeRequest(String name) {
    this.name = name;
  }

  public CreateEmployeeRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @NotNull 
  @Schema(name = "name", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CreateEmployeeRequest firstname(String firstname) {
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

  public CreateEmployeeRequest service(String service) {
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

  public CreateEmployeeRequest floor(Integer floor) {
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

  public CreateEmployeeRequest email(String email) {
    this.email = email;
    return this;
  }

  /**
   * The email must be uniq
   * @return email
  */
  @jakarta.validation.constraints.Email 
  @Schema(name = "email", description = "The email must be uniq", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public CreateEmployeeRequest address(Address address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
  */
  @Valid 
  @Schema(name = "address", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("address")
  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateEmployeeRequest createEmployeeRequest = (CreateEmployeeRequest) o;
    return Objects.equals(this.name, createEmployeeRequest.name) &&
        Objects.equals(this.firstname, createEmployeeRequest.firstname) &&
        Objects.equals(this.service, createEmployeeRequest.service) &&
        Objects.equals(this.floor, createEmployeeRequest.floor) &&
        Objects.equals(this.email, createEmployeeRequest.email) &&
        Objects.equals(this.address, createEmployeeRequest.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, firstname, service, floor, email, address);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateEmployeeRequest {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    firstname: ").append(toIndentedString(firstname)).append("\n");
    sb.append("    service: ").append(toIndentedString(service)).append("\n");
    sb.append("    floor: ").append(toIndentedString(floor)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
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


package be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.dto;

/**
 * This class is a data transfer object for a list employee. It is used to send data to the outside.
 */
public record EmployeeListDto(
    // The last name.
    String name,

    // The first name.
    String firstname) {}

package be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.query;

/**
 * This query is used to get one employee by id.
 *
 * @param id
 */
public record EmployeeQuery(
    // The employee id
    Long id) {}

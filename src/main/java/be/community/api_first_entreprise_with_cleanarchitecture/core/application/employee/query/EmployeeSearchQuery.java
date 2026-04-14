package be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.query;

/**
 * This query is used to search employees.
 *
 * @param name the name of employee
 */
public record EmployeeSearchQuery(
    // The name
    String name) {}

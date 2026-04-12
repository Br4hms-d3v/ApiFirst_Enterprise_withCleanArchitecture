package be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.query;

/**
 * This query is used to get a list of employees.
 *
 * @param page the number of page
 * @param size the size of page
 */
public record EmployeeListQuery(
    // The page number
    int page,

    // The page size
    int size) {}

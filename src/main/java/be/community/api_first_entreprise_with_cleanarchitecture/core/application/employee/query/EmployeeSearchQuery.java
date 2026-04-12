package be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.query;

/**
 * This query is used to search employees.
 *
 * @param name the name of employee
 * @param firstName the first name of employee
 * @param service the service where the employee works
 * @param page the number of pages
 * @param size the size of number of page
 */
public record EmployeeSearchQuery(
    // The name
    String name,

    // The first name
    String firstName,

    // The service where he/she works
    String service,

    // Te number of page
    int page,

    // the size of page
    int size) {}

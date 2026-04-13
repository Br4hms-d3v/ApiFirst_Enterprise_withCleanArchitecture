package be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.command;

/**
 * This command is used to update an employee
 *
 * @param id the identifier
 * @param name the name
 * @param firstName the first name
 * @param service the service where the employee works
 * @param floor the floor number where the employee works
 */
public record UpdateEmployeeCommand(
    // The id of the employee.
    Long id,

    // The last name.
    String name,

    // The first name.
    String firstName,

    // The service (department).
    String service,

    // The floor number.
    Integer floor) {}

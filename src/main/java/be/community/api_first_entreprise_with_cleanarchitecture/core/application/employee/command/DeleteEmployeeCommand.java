package be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.command;

/**
 * This command is used to delete an employee
 *
 * @param id
 */
public record DeleteEmployeeCommand(
    // The id of the employee.
    Long id) {}

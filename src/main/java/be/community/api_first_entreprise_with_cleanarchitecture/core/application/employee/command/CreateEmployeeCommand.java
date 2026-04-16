package be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.command;

import be.community.api_first_entreprise_with_cleanarchitecture.core.application.address.dto.AddressDto;

/**
 * This command is used to create an employee
 *
 * @param name the name of employee
 * @param firstName the first name of employee
 * @param email the email of employee
 * @param service the service where work the employee
 * @param floor the level floor where the employee work
 * @param address the address where he lives
 */
public record CreateEmployeeCommand(
    // The last name.
    String name,

    // The first name.
    String firstName,

    // The email.
    String email,

    // The service (department).
    String service,

    // The floor number.
    Integer floor,

    // The address of the employee.
    AddressDto address) {}

package be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.dto;

import be.community.api_first_entreprise_with_cleanarchitecture.core.application.address.dto.AddressDto;

/**
 * This class is a data transfer object for employee.
 * It is used to send data to the outside.
 */
public record EmployeeDto(
        //The id of the employee.
        Long id,

        //The last name.
        String name,

        //The first name.
        String firstName,

        // The email.
        String email,

        //The service (department).
        String service,

        //The floor number.
        Integer floor,

        //The address of the employee.
        AddressDto address
) {
}

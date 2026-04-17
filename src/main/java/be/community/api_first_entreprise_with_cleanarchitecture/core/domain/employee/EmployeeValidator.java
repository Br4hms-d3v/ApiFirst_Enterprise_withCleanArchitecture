package be.community.api_first_entreprise_with_cleanarchitecture.core.domain.employee;

import be.community.api_first_entreprise_with_cleanarchitecture.core.application.address.dto.AddressDto;
import be.community.api_first_entreprise_with_cleanarchitecture.core.application.common.Result;
import be.community.api_first_entreprise_with_cleanarchitecture.core.application.common.validation.ValidationChain;
import be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.command.CreateEmployeeCommand;
import be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.command.UpdateEmployeeCommand;
import org.springframework.stereotype.Component;

@Component
public class EmployeeValidator {

  private final EmployeeRepository employeeRepository;

  public EmployeeValidator(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  public Result<EmployeeError, CreateEmployeeCommand> validate(CreateEmployeeCommand command) {
    return ValidationChain.<CreateEmployeeCommand, EmployeeError>of(command)
        .validate(
            c -> c.name() != null && !c.name().trim().isEmpty(),
            new EmployeeError.EmployeeNameIsMissing("The name is missing"))
        .validate(
            c -> isLevelValid(c.floor()),
            new EmployeeError.EmployeeInvalidLevel(
                "The floor must be located between 0 and 6th floors"))
        .validate(
            c -> hasAddress(c.address()),
            new EmployeeError.EmployeeCreationFailed("The employee must have an address"))
        .toResult();
  }

  public Result<EmployeeError, UpdateEmployeeCommand> validateUpdate(
      UpdateEmployeeCommand command) {
    return ValidationChain.<UpdateEmployeeCommand, EmployeeError>of(command)
        .validate(
            c -> c.name() != null && !c.name().trim().isEmpty(),
            new EmployeeError.EmployeeNameIsMissing("The name is missing"))
        .validate(
            c -> isLevelValid(c.floor()),
            new EmployeeError.EmployeeInvalidLevel(
                "The floor must be located between 0 and 6th floors"))
        .validate(
            c -> c.service() != null && !c.service().trim().isEmpty(),
            new EmployeeError.EmployeeServiceMissing("The service is missing"))
        .toResult();
  }

  private boolean hasAddress(AddressDto address) {
    return !address.street().isEmpty() && !address.city().isEmpty() && address.zipCode() != null;
  }

  private boolean isLevelValid(Integer floor) {
    return floor >= 0 && floor <= 6;
  }
}

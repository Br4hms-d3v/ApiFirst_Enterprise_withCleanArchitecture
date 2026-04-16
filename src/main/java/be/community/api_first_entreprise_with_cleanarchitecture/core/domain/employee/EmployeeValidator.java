package be.community.api_first_entreprise_with_cleanarchitecture.core.domain.employee;

import be.community.api_first_entreprise_with_cleanarchitecture.core.application.address.dto.AddressDto;
import be.community.api_first_entreprise_with_cleanarchitecture.core.application.common.Result;
import be.community.api_first_entreprise_with_cleanarchitecture.core.application.common.validation.ValidationChain;
import be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.command.CreateEmployeeCommand;
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

  private boolean hasAddress(AddressDto address) {
    return !address.street().isEmpty() && !address.city().isEmpty() && address.zipCode() != null;
  }

  private boolean isLevelValid(Integer floor) {
    return floor >= 0 && floor <= 6;
  }
}

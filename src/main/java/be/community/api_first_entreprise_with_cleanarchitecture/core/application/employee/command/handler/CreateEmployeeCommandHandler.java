package be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.command.handler;

import be.community.api_first_entreprise_with_cleanarchitecture.core.application.common.CommandHandler;
import be.community.api_first_entreprise_with_cleanarchitecture.core.application.common.Result;
import be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.command.CreateEmployeeCommand;
import be.community.api_first_entreprise_with_cleanarchitecture.core.domain.address.Address;
import be.community.api_first_entreprise_with_cleanarchitecture.core.domain.employee.Employee;
import be.community.api_first_entreprise_with_cleanarchitecture.core.domain.employee.EmployeeError;
import be.community.api_first_entreprise_with_cleanarchitecture.core.domain.employee.EmployeeRepository;
import be.community.api_first_entreprise_with_cleanarchitecture.core.domain.employee.EmployeeValidator;
import org.springframework.stereotype.Service;

@Service
public class CreateEmployeeCommandHandler
    implements CommandHandler<CreateEmployeeCommand, EmployeeError> {

  private final EmployeeRepository employeeRepository;
  private final EmployeeValidator employeeValidator;

  private CreateEmployeeCommandHandler(
      EmployeeRepository employeeRepository, EmployeeValidator employeeValidator) {
    this.employeeRepository = employeeRepository;
    this.employeeValidator = employeeValidator;
  }

  @Override
  public Result<EmployeeError, Result.Unit> handle(CreateEmployeeCommand createEmployeeCommand) {
    return employeeValidator.validate(createEmployeeCommand).flatMap(this::processCommand);
  }

  private Result<EmployeeError, Result.Unit> processCommand(CreateEmployeeCommand command) {
    Employee employee = createEmployeeFromCommand(command);
    boolean emailExist = employeeRepository.emailExists(command.email());

    if (command.email().isEmpty() || command.email().isBlank()) {
      return Result.failure(
          new EmployeeError.EmployeeEmailNotValid("The email address you entered is invalid"));
    }
    if (emailExist) {
      return Result.failure(
          new EmployeeError.EmployeeEmailNotValid(
              "The email address you entered is already in use"));
    }

    employeeRepository.save(employee);

    return Result.success();
  }

  private Employee createEmployeeFromCommand(CreateEmployeeCommand command) {
    Employee employee = new Employee();
    Address newAddress = new Address();

    newAddress.setStreet(command.address().street());
    newAddress.setCity(command.address().city());
    newAddress.setZipCcode(command.address().zipCode());

    employee.setName(command.name());
    employee.setFirstName(command.firstName());
    employee.setEmail(command.email());
    employee.setService(command.service());
    employee.setFloor(command.floor());

    employee.setAddress(newAddress);

    return employee;
  }
}

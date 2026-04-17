package be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.command.handler;

import be.community.api_first_entreprise_with_cleanarchitecture.core.application.common.CommandHandler;
import be.community.api_first_entreprise_with_cleanarchitecture.core.application.common.Result;
import be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.command.UpdateEmployeeCommand;
import be.community.api_first_entreprise_with_cleanarchitecture.core.domain.employee.Employee;
import be.community.api_first_entreprise_with_cleanarchitecture.core.domain.employee.EmployeeError;
import be.community.api_first_entreprise_with_cleanarchitecture.core.domain.employee.EmployeeRepository;
import be.community.api_first_entreprise_with_cleanarchitecture.core.domain.employee.EmployeeValidator;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UpdateEmployeeCommandHandler
    implements CommandHandler<UpdateEmployeeCommand, EmployeeError> {

  private final EmployeeRepository employeeRepository;
  private final EmployeeValidator employeeValidator;

  public UpdateEmployeeCommandHandler(
      EmployeeRepository employeeRepository, EmployeeValidator employeeValidator) {
    this.employeeRepository = employeeRepository;
    this.employeeValidator = employeeValidator;
  }

  @Override
  public Result<EmployeeError, Result.Unit> handle(UpdateEmployeeCommand command) {
    return employeeValidator.validateUpdate(command).flatMap(this::updateEmployeeCommand);
  }

  private Result<EmployeeError, Result.Unit> updateEmployeeCommand(UpdateEmployeeCommand command) {
    Optional<Employee> optionalEmployee = employeeRepository.findById(command.id());

    if (optionalEmployee.isEmpty()) {
      return Result.failure(
          new EmployeeError.EmployeeNotFound(
              "The employee with id " + command.id() + " is not found"));
    }

    Employee entity = optionalEmployee.get();

    entity.setName(command.name());
    entity.setFirstName(command.firstName());
    entity.setService(command.service());
    entity.setFloor(command.floor());

    employeeRepository.save(entity);

    return Result.success();
  }
}

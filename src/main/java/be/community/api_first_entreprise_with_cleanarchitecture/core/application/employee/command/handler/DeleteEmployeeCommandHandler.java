package be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.command.handler;

import be.community.api_first_entreprise_with_cleanarchitecture.core.application.common.CommandHandler;
import be.community.api_first_entreprise_with_cleanarchitecture.core.application.common.Result;
import be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.command.DeleteEmployeeCommand;
import be.community.api_first_entreprise_with_cleanarchitecture.core.domain.employee.EmployeeError;
import be.community.api_first_entreprise_with_cleanarchitecture.core.domain.employee.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteEmployeeCommandHandler implements CommandHandler<DeleteEmployeeCommand, EmployeeError> {

    private final EmployeeRepository employeeRepository;

    public DeleteEmployeeCommandHandler(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Result<EmployeeError, Result.Unit> handle(DeleteEmployeeCommand command) {
        return employeeRepository
                .findById(command.id())
                .<Result<EmployeeError, Result.Unit>>map(entity -> {
                    employeeRepository.deleteById(command.id());
                    return Result.success(Result.Unit.INSTANCE);
                })
                .orElseGet(() -> Result.failure(
                                new EmployeeError.EmployeeNotFound("The employee is not found")
                        )
                );
    }
}

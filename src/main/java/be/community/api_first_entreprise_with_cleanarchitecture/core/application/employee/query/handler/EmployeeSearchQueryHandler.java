package be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.query.handler;

import be.community.api_first_entreprise_with_cleanarchitecture.core.application.common.QueryHandler;
import be.community.api_first_entreprise_with_cleanarchitecture.core.application.common.Result;
import be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.dto.EmployeeDto;
import be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.mapper.EmployeeMapper;
import be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.query.EmployeeSearchQuery;
import be.community.api_first_entreprise_with_cleanarchitecture.core.domain.employee.Employee;
import be.community.api_first_entreprise_with_cleanarchitecture.core.domain.employee.EmployeeError;
import be.community.api_first_entreprise_with_cleanarchitecture.core.domain.employee.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class EmployeeSearchQueryHandler implements QueryHandler<EmployeeSearchQuery, List<EmployeeDto>, EmployeeError> {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeSearchQueryHandler(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public Result<EmployeeError, List<EmployeeDto>> handle(EmployeeSearchQuery query) {
        if (query.name() == null || query.name().isEmpty()) {
            new EmployeeError.EmployeeNotFound("The name of the employee is not found");
        }

        List<Employee> employeesByName = employeeRepository.searchByName(query.name());

        if (employeesByName.isEmpty()) {
            new EmployeeError.EmployeeListIsEmpty("The list of employee names is empty");
        }

        List<EmployeeDto> result = employeesByName
                .stream()
                .map(employeeMapper::toDto)
                .toList();

        return Result.success(result);
    }
}

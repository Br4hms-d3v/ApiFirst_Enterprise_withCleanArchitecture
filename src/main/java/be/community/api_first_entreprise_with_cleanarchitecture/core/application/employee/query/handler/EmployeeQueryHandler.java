package be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.query.handler;

import be.community.api_first_entreprise_with_cleanarchitecture.core.application.common.QueryHandler;
import be.community.api_first_entreprise_with_cleanarchitecture.core.application.common.Result;
import be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.dto.EmployeeDto;
import be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.mapper.EmployeeMapper;
import be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.query.EmployeeQuery;
import be.community.api_first_entreprise_with_cleanarchitecture.core.domain.employee.EmployeeError;
import be.community.api_first_entreprise_with_cleanarchitecture.core.domain.employee.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class EmployeeQueryHandler
    implements QueryHandler<EmployeeQuery, EmployeeDto, EmployeeError> {

  private final EmployeeRepository employeeRepository;
  private final EmployeeMapper employeeMapper;

  public EmployeeQueryHandler(
      EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
    this.employeeRepository = employeeRepository;
    this.employeeMapper = employeeMapper;
  }

  /**
   * Handle employee query
   *
   * @param query the query
   * @return a result success or failure
   */
  @Override
  public Result<EmployeeError, EmployeeDto> handle(EmployeeQuery query) {
    if (query.id() == null) {
      return Result.failure(new EmployeeError.EmployeeInvalidFailed("Id is required"));
    }
    return employeeRepository
        .findById(query.id())
        .map(employeeMapper::toDto)
        //                .map(dto -> Result.<EmployeeError, EmployeeDto>success(dto)) THIS IS OLD
        // VERSION
        .map(Result::<EmployeeError, EmployeeDto>success)
        .orElseGet(
            () ->
                Result.failure(
                    new EmployeeError.EmployeeNotFound(
                        "Employee not found with id: " + query.id())));
  }
}

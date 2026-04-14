package be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.query.handler;

import be.community.api_first_entreprise_with_cleanarchitecture.core.application.common.PagedResponseMapper;
import be.community.api_first_entreprise_with_cleanarchitecture.core.application.common.QueryHandler;
import be.community.api_first_entreprise_with_cleanarchitecture.core.application.common.Result;
import be.community.api_first_entreprise_with_cleanarchitecture.core.application.common.dto.PagedResponseDto;
import be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.dto.EmployeeListDto;
import be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.mapper.EmployeeMapper;
import be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.query.EmployeeListQuery;
import be.community.api_first_entreprise_with_cleanarchitecture.core.domain.employee.EmployeeError;
import be.community.api_first_entreprise_with_cleanarchitecture.core.domain.employee.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class EmployeeListQueryHandler
    implements QueryHandler<EmployeeListQuery, PagedResponseDto<EmployeeListDto>, EmployeeError> {

  private final EmployeeRepository employeeRepository;
  private final EmployeeMapper employeeMapper;

  public EmployeeListQueryHandler(
      EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
    this.employeeRepository = employeeRepository;
    this.employeeMapper = employeeMapper;
  }

  @Override
  public Result<EmployeeError, PagedResponseDto<EmployeeListDto>> handle(EmployeeListQuery query) {
    return Result.success(
        PagedResponseMapper.toPagedResponseDto(
            employeeRepository.findAll(query.page(), query.size()), employeeMapper::toListDtoList));
  }
}

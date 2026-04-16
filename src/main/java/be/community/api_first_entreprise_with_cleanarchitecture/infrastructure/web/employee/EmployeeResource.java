package be.community.api_first_entreprise_with_cleanarchitecture.infrastructure.web.employee;

import be.community.api_first_entreprise_with_cleanarchitecture.core.application.address.dto.AddressDto;
import be.community.api_first_entreprise_with_cleanarchitecture.core.application.common.Result;
import be.community.api_first_entreprise_with_cleanarchitecture.core.application.common.dto.PagedResponseDto;
import be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.command.CreateEmployeeCommand;
import be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.command.handler.CreateEmployeeCommandHandler;
import be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.dto.EmployeeDto;
import be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.dto.EmployeeListDto;
import be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.query.EmployeeListQuery;
import be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.query.EmployeeQuery;
import be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.query.EmployeeSearchQuery;
import be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.query.handler.EmployeeListQueryHandler;
import be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.query.handler.EmployeeQueryHandler;
import be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.query.handler.EmployeeSearchQueryHandler;
import be.community.api_first_entreprise_with_cleanarchitecture.core.domain.employee.EmployeeError;
import java.util.List;
import java.util.Objects;
import org.openapitools.api.EmployeeApi;
import org.openapitools.model.CreateEmployeeRequest;
import org.openapitools.model.EmployeeResponse;
import org.openapitools.model.Employees;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class EmployeeResource implements EmployeeApi {

  private final EmployeeQueryHandler employeeQueryHandler;
  private final EmployeeListQueryHandler employeeListQueryHandler;
  private final EmployeeSearchQueryHandler employeeSearchQueryHandler;

  private final CreateEmployeeCommandHandler createEmployeeCommandHandler;

  public EmployeeResource(
      EmployeeQueryHandler employeeQueryHandler,
      EmployeeListQueryHandler employeeListQueryHandler,
      EmployeeSearchQueryHandler employeeSearchQueryHandler,
      CreateEmployeeCommandHandler createEmployeeCommandHandler) {
    this.employeeQueryHandler = employeeQueryHandler;
    this.employeeListQueryHandler = employeeListQueryHandler;
    this.employeeSearchQueryHandler = employeeSearchQueryHandler;
    this.createEmployeeCommandHandler = createEmployeeCommandHandler;
  }

  ///////////////////////// Query /////////////////////////

  /**
   * Get employe by ID
   *
   * @param id (required)
   * @return detail about the employee
   */
  @Override
  public ResponseEntity<EmployeeResponse> getEmployeeId(Long id) {
    var query = new EmployeeQuery(id);

    Result<EmployeeError, EmployeeDto> result = employeeQueryHandler.handle(query);

    return result.fold(
        this::handleEmployeeError,
        employeeDto -> ResponseEntity.ok(EmployeeResourceMapper.toEmployeeResponse(employeeDto)));
  }

  /**
   * Get a list employees
   *
   * @param pageNumber The page to be displayed. Default is 1 (optional, default to 1)
   * @param pageSize The number of items per page. Default is 20 (optional, default to 20)
   * @return a list of employees with pagination
   */
  @Override
  public ResponseEntity<List<Employees>> getEmployees(Integer pageNumber, Integer pageSize) {
    var query = new EmployeeListQuery(pageNumber, pageSize);
    Result<EmployeeError, PagedResponseDto<EmployeeListDto>> result =
        employeeListQueryHandler.handle(query);

    return result.fold(
        this::handleEmployeeError,
        pageDTO ->
            new ResponseEntity<>(
                pageDTO.content().stream()
                    .map(EmployeeResourceMapper::toListEmployeeResponse)
                    .toList(),
                HttpStatus.OK));
  }

  /**
   * Get a list of employee by name
   *
   * @param name (required) the name of employee
   * @return a list or simple employee by name
   */
  @Override
  public ResponseEntity<List<EmployeeResponse>> getListEmployeeByName(String name) {
    var query = new EmployeeSearchQuery(name);

    Result<EmployeeError, List<EmployeeDto>> result = employeeSearchQueryHandler.handle(query);

    return result.fold(
        this::handleEmployeeError,
        employeeDto -> {
          if (employeeDto == null || employeeDto.isEmpty()) {
            return handleEmployeeError(
                new EmployeeError.EmployeeListIsEmpty("List of employee is empty"));
          }
          return ResponseEntity.ok(EmployeeResourceMapper.toListEmployees(employeeDto));
        });
  }

  /// ////////////////////// Command /////////////////////////

  public ResponseEntity<Void> createEmployee(CreateEmployeeRequest createEmployeeRequest) {
    AddressDto addressDto =
        new AddressDto(
            createEmployeeRequest.getAddress().getStreet(),
            createEmployeeRequest.getAddress().getZipcode(),
            createEmployeeRequest.getAddress().getCity());

    CreateEmployeeCommand command =
        new CreateEmployeeCommand(
            createEmployeeRequest.getName(),
            createEmployeeRequest.getFirstname(),
            createEmployeeRequest.getEmail(),
            createEmployeeRequest.getService(),
            createEmployeeRequest.getFloor(),
            addressDto);

    System.out.println("firstname: " + createEmployeeRequest.getFirstname());
    var result = createEmployeeCommandHandler.handle(command);

    return result.fold(
        this::handleEmployeeError, success -> new ResponseEntity<>(HttpStatus.CREATED));
  }

  // This is a design patter for Error Employee
  private <T> ResponseEntity<T> handleEmployeeError(EmployeeError error) {
    switch (Objects.requireNonNull(error)) {
      case EmployeeError.EmployeeNotFound(var message) ->
          throw new ResponseStatusException(HttpStatus.NOT_FOUND, message);
      case EmployeeError.EmployeeNameIsMissing(var message) ->
          throw new ResponseStatusException(HttpStatus.BAD_REQUEST, message);
      case EmployeeError.EmployeeCreationFailed(var message) ->
          throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, message);
      case EmployeeError.EmployeeInvalidFailed(var message) ->
          throw new ResponseStatusException(HttpStatus.BAD_REQUEST, message);
      case EmployeeError.EmployeeListIsEmpty(var message) ->
          throw new ResponseStatusException(HttpStatus.NOT_FOUND, message);
      case EmployeeError.EmployeeInvalidLevel(var message) ->
          throw new ResponseStatusException(HttpStatus.BAD_REQUEST, message);
      case EmployeeError.EmployeeEmailNotValid(var message) ->
          throw new ResponseStatusException(HttpStatus.BAD_REQUEST, message);
      default -> {
        System.out.println("UNHANDLED ERROR: " + error.getClass());
        throw new ResponseStatusException(
            HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error");
      }
    }
  }
}

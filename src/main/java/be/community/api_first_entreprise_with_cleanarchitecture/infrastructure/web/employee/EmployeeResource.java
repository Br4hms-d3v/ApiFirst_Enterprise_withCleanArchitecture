package be.community.api_first_entreprise_with_cleanarchitecture.infrastructure.web.employee;

import be.community.api_first_entreprise_with_cleanarchitecture.core.application.common.Result;
import be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.dto.EmployeeDto;
import be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.query.EmployeeQuery;
import be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.query.handler.EmployeeQueryHandler;
import be.community.api_first_entreprise_with_cleanarchitecture.core.domain.employee.EmployeeError;
import java.util.Objects;
import org.openapitools.api.EmployeeApi;
import org.openapitools.model.EmployeeResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class EmployeeResource implements EmployeeApi {

  private final EmployeeQueryHandler employeeQueryHandler;

  public EmployeeResource(EmployeeQueryHandler employeeQueryHandler) {
    this.employeeQueryHandler = employeeQueryHandler;
  }

  @Override
  public ResponseEntity<EmployeeResponse> getEmployeeId(Long id) {
    var query = new EmployeeQuery(id);

    Result<EmployeeError, EmployeeDto> result = employeeQueryHandler.handle(query);

    return result.fold(
        this::handleEmployeeError,
        employeeDto -> ResponseEntity.ok(EmployeeResourceMapper.toEmployeeResponse(employeeDto)));
  }

  // This is a design patter for Error Employee
  private <T> ResponseEntity<T> handleEmployeeError(EmployeeError error) {
    switch (Objects.requireNonNull(error)) {
      case EmployeeError.EmployeeNotFound(var message) ->
          throw new ResponseStatusException(HttpStatus.NOT_FOUND, message);
      case EmployeeError.EmployeeInvalidFailed(var message) ->
          throw new ResponseStatusException(HttpStatus.BAD_REQUEST, message);
      default ->
          throw new ResponseStatusException(
              HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error");
    }
  }
}

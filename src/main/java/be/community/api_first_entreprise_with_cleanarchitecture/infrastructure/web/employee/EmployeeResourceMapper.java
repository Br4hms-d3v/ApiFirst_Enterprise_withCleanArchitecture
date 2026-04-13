package be.community.api_first_entreprise_with_cleanarchitecture.infrastructure.web.employee;

import be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.dto.EmployeeDto;
import be.community.api_first_entreprise_with_cleanarchitecture.infrastructure.web.address.AddressResourceMapper;
import org.openapitools.model.EmployeeResponse;

public class EmployeeResourceMapper {

  private EmployeeResourceMapper() {}

  public static EmployeeResponse toEmployeeResponse(EmployeeDto dto) {
    if (dto == null) return null;
    return new EmployeeResponse()
        .name(dto.name())
        .firstname(dto.firstName())
        .service(dto.service())
        .floor(dto.floor())
        .address(AddressResourceMapper.toAddressResponse(dto.address()));
  }
}

package be.community.api_first_entreprise_with_cleanarchitecture.infrastructure.web.employee;

import be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.dto.EmployeeDto;
import be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.dto.EmployeeListDto;
import be.community.api_first_entreprise_with_cleanarchitecture.infrastructure.web.address.AddressResourceMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.openapitools.model.EmployeeResponse;
import org.openapitools.model.Employees;

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

  public static Employees toListEmployeeResponse(EmployeeListDto dto) {
    return new Employees().name(dto.name()).firstname(dto.firstname());
  }

  public static List<EmployeeResponse> toListEmployees(List<EmployeeDto> dtos) {
    if (dtos == null) {
      return List.of();
    }

    return dtos.stream()
        .map(EmployeeResourceMapper::toEmployeeResponse)
        .collect(Collectors.toList());
  }
}

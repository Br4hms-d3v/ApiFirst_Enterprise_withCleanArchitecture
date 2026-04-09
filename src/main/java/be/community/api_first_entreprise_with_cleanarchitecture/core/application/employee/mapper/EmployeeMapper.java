package be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.mapper;

import be.community.api_first_entreprise_with_cleanarchitecture.core.application.address.mapper.AddressMapper;
import be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.dto.EmployeeDto;
import be.community.api_first_entreprise_with_cleanarchitecture.core.application.employee.dto.EmployeeListDto;
import be.community.api_first_entreprise_with_cleanarchitecture.core.domain.employee.Employee;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * This mapper converts Employee and EmployeeDto.
 */
@Component
public class EmployeeMapper {
    private final AddressMapper addressMapper;

    public EmployeeMapper(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    /**
     * Convert Employee to EmployeeDto (full data).
     */
    public EmployeeDto toDto(Employee employee) {
        if (employee == null) {
            return null;
        }

        return new EmployeeDto(
                employee.getId(),
                employee.getName(),
                employee.getFirstName(),
                employee.getEmail(),
                employee.getService(),
                employee.getFloor(),
                addressMapper.toDto(employee.getAddress())
        );
    }

    /**
     * Convert Employee to EmployeeListDto (light data).
     */
    public EmployeeListDto toListDto(Employee employee) {
        if (employee == null) {
            return null;
        }

        return new EmployeeListDto(
                employee.getName(),
                employee.getFirstName()
        );
    }

    /**
     * Convert list of Employee to list of EmployeeListDto.
     */
    public List<EmployeeListDto> toListDtoList(List<Employee> employees) {
        return employees.stream()
                .map(this::toListDto)
                .toList();
    }
}

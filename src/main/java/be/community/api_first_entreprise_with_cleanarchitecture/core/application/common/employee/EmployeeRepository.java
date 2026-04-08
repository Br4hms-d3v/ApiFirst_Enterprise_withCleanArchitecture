package be.community.api_first_entreprise_with_cleanarchitecture.core.application.common.employee;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;

public interface EmployeeRepository {
  Optional<Employee> findById(Long id);

  Page<Employee> findAll(int pageNumber, int pageSize);

  void createEmployee(Employee employee);

  void updateEmployee(Employee employee);

  void deleteById(Long id);

  List<Employee> searchByName(String name);

  Boolean emailExisting(String email);
}

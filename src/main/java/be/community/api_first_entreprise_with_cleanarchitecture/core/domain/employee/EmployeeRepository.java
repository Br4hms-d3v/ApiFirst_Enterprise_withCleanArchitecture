package be.community.api_first_entreprise_with_cleanarchitecture.core.domain.employee;

import java.util.Optional;

public interface EmployeeRepository {
  Optional<Employee> findById(long id);
}

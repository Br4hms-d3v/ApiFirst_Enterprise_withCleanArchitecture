package be.community.api_first_entreprise_with_cleanarchitecture.infrastructure.persistence.employee;

import be.community.api_first_entreprise_with_cleanarchitecture.core.domain.employee.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaEmployeeRepository extends JpaRepository<Employee, Long> {

  List<Employee> searchByName(String name);

  boolean existsByEmail(String email);
}

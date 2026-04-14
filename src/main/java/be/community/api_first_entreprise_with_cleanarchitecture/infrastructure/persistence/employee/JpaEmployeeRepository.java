package be.community.api_first_entreprise_with_cleanarchitecture.infrastructure.persistence.employee;

import be.community.api_first_entreprise_with_cleanarchitecture.core.domain.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaEmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> searchByName(String name);
}

package be.community.api_first_entreprise_with_cleanarchitecture.core.domain.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

public interface EmployeeRepository {
    Optional<Employee> findById(long id);

    Page<Employee> findAll(int pageNumber, int pageSize);

    List<Employee> searchByName(String name);
}

package be.community.api_first_entreprise_with_cleanarchitecture.infrastructure.persistence.employee;

import be.community.api_first_entreprise_with_cleanarchitecture.core.domain.employee.Employee;
import be.community.api_first_entreprise_with_cleanarchitecture.core.domain.employee.EmployeeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeJpaAdapter implements EmployeeRepository {

  private final JpaEmployeeRepository jpaEmployeeRepository;

  public EmployeeJpaAdapter(JpaEmployeeRepository jpaEmployeeRepository) {
    this.jpaEmployeeRepository = jpaEmployeeRepository;
  }

  @Override
  public Optional<Employee> findById(long id) {
    return jpaEmployeeRepository.findById(id);
  }

  @Override
  public Page<Employee> findAll(int pageNumber, int pageSize) {
    return jpaEmployeeRepository.findAll(PageRequest.of(pageNumber, pageSize));
  }

  @Override
  public List<Employee> searchByName(String name) {
    return jpaEmployeeRepository.searchByName(name);
  }
}

package be.community.api_first_entreprise_with_cleanarchitecture.infrastructure.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import be.community.api_first_entreprise_with_cleanarchitecture.core.domain.address.Address;
import be.community.api_first_entreprise_with_cleanarchitecture.core.domain.employee.Employee;
import be.community.api_first_entreprise_with_cleanarchitecture.infrastructure.persistence.employee.JpaEmployeeRepository;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeTestUnit {

  @Autowired JpaEmployeeRepository jpaEmployeeRepository;

  @Test
  void createEmployee() {
    Employee employee = new Employee();
    Address address = new Address();

    employee.setName("Badouri");
    employee.setFirstName("Rachid");
    employee.setService("RH");
    employee.setFloor(2);

    address.setStreet("Chaussée de mons 451");
    address.setCity("Bruxelles");
    address.setZipCode(1070);

    employee.setAddress(address);

    jpaEmployeeRepository.save(employee);
  }

  @Test
  void listEmployeesShouldReturnSuccess() {
    assertThat(jpaEmployeeRepository.findAll()).hasSize(5);
  }

  @Test
  void findEmployeeByIdShouldReturnSuccess() {
    Optional<Employee> employee = jpaEmployeeRepository.findById(1L);

    assertThat(employee).isPresent();
  }

  @Test
  void updateEmployee() {
    Employee oldEmployee = new Employee();
    oldEmployee.setFirstName("Bob");
    oldEmployee.setName("Marley");
    jpaEmployeeRepository.save(oldEmployee);

    var updateEmployee = new Employee();
    updateEmployee.setName("Jackson");
    updateEmployee.setFirstName("Jackson");
    jpaEmployeeRepository.save(updateEmployee);

    assertNotNull(updateEmployee.getName());
    assertEquals("Jackson", updateEmployee.getFirstName());
  }

  @Test
  void deleteEmployeeByIdShouldReturnSuccess() {
    jpaEmployeeRepository.deleteById(1L);
    List<Employee> employees = jpaEmployeeRepository.findAll();
    assertThat(employees).hasSize(4);
  }
}

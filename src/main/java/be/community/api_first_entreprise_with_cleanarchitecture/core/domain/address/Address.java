package be.community.api_first_entreprise_with_cleanarchitecture.core.domain.address;

import be.community.api_first_entreprise_with_cleanarchitecture.core.domain.employee.Employee;
import jakarta.persistence.*;

/**
 * This class represents an address.
 * An address belongs to one employee.
 */
@Entity
public class Address {

    /**
     * The unique id of the address.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The street name.
     */
    private String street;

    /**
     * The postcode of the city.
     */
    private Integer zipCode;

    /**
     * The city name.
     */
    private String city;

    /**
     * The employee who owns this address.
     */
    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL, orphanRemoval = true)
    private Employee employee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCcode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}

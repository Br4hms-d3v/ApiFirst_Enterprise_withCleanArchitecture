package be.community.api_first_entreprise_with_cleanarchitecture.core.domain.employee;

import be.community.api_first_entreprise_with_cleanarchitecture.core.domain.address.Address;
import jakarta.persistence.*;

/**
 * This class represents an employee.
 * An employee has personal data and one address.
 */
@Entity
public class Employee {
    /**
     * The unique id of the employee.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The last name of the employee.
     */
    private String name;

    /**
     * The first name of the employee.
     */
    private String firstName;

    /**
     * The email of the employee.
     * It must be unique.
     */
    @Column(unique = true)
    private String email;

    /**
     * The service (department) of the employee.
     */
    private String service;

    /**
     * The floor where the employee works.
     */
    private Integer floor;

    /**
     * The address of the employee.
     */
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", unique = true)
    private Address address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
        if (address != null) {
            address.setEmployee(this);
        }
    }
}

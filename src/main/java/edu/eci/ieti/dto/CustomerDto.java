package edu.eci.ieti.dto;

import edu.eci.ieti.entity.Customer;

public class CustomerDto {

    private String id;
    private String name;
    private String email;
    private String lastname;
    private String createdAt;

    public CustomerDto() {
    }

    public CustomerDto(String id, String name, String email, String lastname, String createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.lastname = lastname;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Customer toCustomer() {
        return new Customer(id, name, email, lastname, createdAt);
    }

}

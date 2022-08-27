package edu.eci.ieti.service;

import java.util.List;
import edu.eci.ieti.entity.Customer;

public interface CustomerService {
    Customer create(Customer user);

    Customer findById(String id);

    List<Customer> getAll();

    void deleteById(String id);

    Customer update(Customer user, String userId);
}

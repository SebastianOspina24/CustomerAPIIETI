package edu.eci.ieti.service;

import java.util.List;
import edu.eci.ieti.entity.Customer;

public interface CustomerService {
    Customer create(Customer customer);

    Customer findById(String id);

    List<Customer> getAll();

    boolean deleteById(String id);

    Customer update(Customer customer, String customerId);
}

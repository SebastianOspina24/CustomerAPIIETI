package edu.eci.ieti.service.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.eci.ieti.entity.Customer;
import edu.eci.ieti.service.CustomerService;

@Service
public class CustomerServiceHashMap implements CustomerService {

    private HashMap<String, Customer> persistence;

    @Override
    public Customer create(Customer customer) {
        persistence.put(customer.getId(), customer);
        return customer;
    }

    @Override
    public Customer findById(String id) {
        return persistence.get(id);
    }

    @Override
    public List<Customer> getAll() {
        return new ArrayList<Customer>(persistence.values());
    }

    @Override
    public void deleteById(String id) {
        persistence.remove(id);
    }

    @Override
    public Customer update(Customer customer, String userId) {
        deleteById(userId);
        return create(customer);
    }

}

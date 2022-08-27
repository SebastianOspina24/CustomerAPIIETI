package edu.eci.ieti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.eci.ieti.dto.CustomerDto;
import edu.eci.ieti.service.CustomerService;

@RestController
@RequestMapping("/api/v2/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAll() {
        ArrayList<CustomerDto> customers = new ArrayList<>();
        customerService.getAll().forEach((user) -> customers.add(user.toCustomerDTO()));
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> findById(@PathVariable String id) {
        return ResponseEntity.ok(customerService.findById(id).toCustomerDTO());
    }

    @PostMapping
    public ResponseEntity<CustomerDto> create(@RequestBody CustomerDto customer) {
        return ResponseEntity.ok(customerService.create(customer.toCustomer()).toCustomerDTO());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> update(@RequestBody CustomerDto customer, @PathVariable String id) {
        return ResponseEntity.ok(customerService.update(customer.toCustomer(), id).toCustomerDTO());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id) {
        boolean flag = customerService.findById(id) != null;
        if (flag)
            customerService.deleteById(id);
        return ResponseEntity.ok(flag);
    }
}

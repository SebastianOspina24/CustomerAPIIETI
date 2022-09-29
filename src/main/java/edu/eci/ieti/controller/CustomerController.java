package edu.eci.ieti.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.eci.ieti.dto.CustomerDto;
import edu.eci.ieti.entity.Customer;
import edu.eci.ieti.service.CustomerService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v2/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAll() {
        ArrayList<CustomerDto> customers = new ArrayList<>();
        customerService.getAll().forEach((customer) -> customers.add(customer.toCustomerDTO()));
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> findById(@PathVariable String id) {
        Customer customer = customerService.findById(id);
        return ResponseEntity
                .ok((customer != null) ? customer.toCustomerDTO() : null);
    }

    @PostMapping
    public ResponseEntity<CustomerDto> create(@RequestBody CustomerDto customer) {
        if (customer != null)
            return ResponseEntity.ok(customerService.create(customer.toCustomer()).toCustomerDTO());
        else
            return ResponseEntity.badRequest().body(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> update(@RequestBody CustomerDto customer, @PathVariable String id) {
        if (customer != null)
            return ResponseEntity.ok(customerService.update(customer.toCustomer(), id).toCustomerDTO());
        else
            return ResponseEntity.badRequest().body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id) {
        return ResponseEntity.ok(customerService.deleteById(id));
    }
}

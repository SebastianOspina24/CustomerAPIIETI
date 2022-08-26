package edu.eci.ieti.controller;

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
        // TODO implement this method using UserService
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> findById(@PathVariable String id) {
        // TODO implement this method using UserService
        return null;
    }

    @PostMapping
    public ResponseEntity<CustomerDto> create(@RequestBody CustomerDto userDto) {
        // TODO implement this method using UserService
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> update(@RequestBody CustomerDto customer, @PathVariable String id) {
        // TODO implement this method using UserService
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id) {
        // TODO implement this method using UserService
        return null;
    }
}

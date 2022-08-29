package edu.eci.ieti.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import edu.eci.ieti.entity.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

}

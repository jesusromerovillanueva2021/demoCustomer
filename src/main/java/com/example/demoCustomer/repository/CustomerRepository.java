package com.example.demoCustomer.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.example.demoCustomer.entity.Customer;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, Integer> {
	
}

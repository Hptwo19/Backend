package com.DigitalStore.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.DigitalStore.Model.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
	
	public List<Customer> findByEmail(String email);
	public List<Customer> findByFirstName(String firstName);
}

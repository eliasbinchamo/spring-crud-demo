package com.elias.springcruddemo.repository;

import com.elias.springcruddemo.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer,Long>{
    Iterable<Customer> findByLastName(String lastName);
}

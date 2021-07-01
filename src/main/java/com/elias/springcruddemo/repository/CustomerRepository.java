package com.elias.springcruddemo.repository;

import com.elias.springcruddemo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
    List<Customer> getByLastName(String name);
}

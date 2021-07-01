package com.elias.springcruddemo.controller;

import com.elias.springcruddemo.entity.Customer;
import com.elias.springcruddemo.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    private final CustomerRepository customerRepository;

    CustomerController(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @GetMapping("/")
    public Iterable<Customer> getCustomers(){
        return customerRepository.findAll();
    }
    @GetMapping("/customers/{Id}")
    public Customer getCustomerById(@PathVariable Long Id){
        return customerRepository.findById(Id).get();
    }
    @GetMapping("/customers/{lastName}")
    public List<Customer> getCustomersByLastName(@PathVariable String name){
        return customerRepository.getByLastName(name);
    }
    @PostMapping("/")
    public Customer getCustomerById(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }
    @DeleteMapping("customers/{Id}")
    public void deleteCustomerById(@PathVariable Long Id){
        customerRepository.deleteById(Id);
    }

}

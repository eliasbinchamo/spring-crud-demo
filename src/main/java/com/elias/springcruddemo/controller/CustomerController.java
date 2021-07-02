package com.elias.springcruddemo.controller;

import com.elias.springcruddemo.entity.Customer;
import com.elias.springcruddemo.entity.Lesson;
import com.elias.springcruddemo.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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
    @GetMapping("/test")
    public String isCustomer(){
        Customer cs = new Customer("elias","binchamo");
        return cs.getClass()+"";
    }
    @PostMapping("/randomlist")
    List<String> getList(@PathVariable String ...inp){
        return Arrays.asList(inp);
    }
    @GetMapping("/customers/{Id}")
    public Customer getCustomerById(@PathVariable Long Id){
        return customerRepository.findById(Id).get();
    }
    @GetMapping("/customers/getByLast/{lastName}")
    public Iterable<Customer> findBylastName(@PathVariable String lastName){
        return customerRepository.findByLastName(lastName);
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

package com.example.demo.controller;

import com.example.demo.domain.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Customers")
public class CustomerController {

    private final CustomerRepository repository;

    public CustomerController(CustomerRepository repository){
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<Customer> all() {
        return this.repository.findAll();
    }

    @PostMapping("")
    public Customer create(@RequestBody Customer customer) {
        return this.repository.save(customer);
    }

    @GetMapping("/lastname/{lastName}")
    public Iterable<Customer> findByLastName(@PathVariable String lastName) {
        return this.repository.findByLastName(lastName);
    }

}

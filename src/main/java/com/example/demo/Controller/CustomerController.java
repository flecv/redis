package com.example.demo.Controller;


import com.example.demo.Customer1.Customer;
import com.example.demo.repository.CustomerRepo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "customer")
public class CustomerController {
    private CustomerRepo repo;
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer){
        repo.save(new Customer(customer.getId(),customer.getName(),customer.getAge()));
        return repo.findById(customer.getId());

    }
}

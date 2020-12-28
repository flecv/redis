package com.example.demo.Controller;


import com.example.demo.Customer1.Customer;
import com.example.demo.repository.CustomerRepo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "customer")
public class CustomerController {
    private CustomerRepo repo;
    public CustomerController (CustomerRepo repo)
    {
        this.repo=repo;
    }
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer){
        repo.save(new Customer(customer.getId(),customer.getName(),customer.getAge()));
        return repo.findById(customer.getId());

    }
    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable("id") final String id){
        return repo.findById(id);
    }
}

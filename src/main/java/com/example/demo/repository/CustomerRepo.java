package com.example.demo.repository;
import com.example.demo.Customer1.Customer;

public interface CustomerRepo {

    Customer findById(String id);

    void save(Customer customer);

}

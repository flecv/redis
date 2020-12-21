package repository;

import Customer.Customer;

public interface CustomerRepo {
    Customer findById(String id);
    void save(Customer customer);
}

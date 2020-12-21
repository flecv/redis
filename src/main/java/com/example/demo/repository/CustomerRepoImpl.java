package com.example.demo.repository;

import com.example.demo.Customer1.Customer;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepoImpl implements CustomerRepo{

    private RedisTemplate<String, Customer> redisTemplate;
    private HashOperations hashOperations;

    public CustomerRepoImpl(RedisTemplate<String, Customer> redisTemplate) {
        this.redisTemplate = redisTemplate;

        this.hashOperations = redisTemplate.opsForHash();
    }
    @Override
    public Customer findById(String id) {
        return (Customer) hashOperations.get("Customer",id);
    }
    @Override
    public void save(Customer customer) {
        hashOperations.put("Customer",customer.getId(),customer);
    }
}

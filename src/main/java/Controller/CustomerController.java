package Controller;


import Customer.Customer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.CustomerRepo;

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

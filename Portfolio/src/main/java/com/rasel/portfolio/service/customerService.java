package com.rasel.portfolio.service;

import com.rasel.portfolio.model.Customer;
import com.rasel.portfolio.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class customerService {



    private final CustomerRepository customerRepository;
    public customerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

   public Customer save(Customer customer){
        return customerRepository.save(customer);
   }

   public List<Customer> getAll(){
//        return (List<Customer>) customerRepository.findAll();
        return customerRepository.findAll();
    }


}

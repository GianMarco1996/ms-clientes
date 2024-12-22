package com.bootcamp.customer.service;

import com.bootcamp.customer.model.Customer;
import com.bootcamp.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Flux<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Mono<Customer> getCustomer(String id) {
        return customerRepository.findById(id);
    }

    @Override
    public Mono<Customer> registerCustomer(Mono<Customer> customer) {
        return customer.flatMap(customerRepository::insert);
    }

    @Override
    public Mono<Customer> updateCustomer(String id, Mono<Customer> customer) {
        return customerRepository.findById(id)
                .flatMap(c -> customer)
                .doOnNext(e -> e.setId(id))
                .flatMap(customerRepository::save);
    }

    @Override
    public Mono<Void> removeCustomer(String id) {
        return customerRepository.deleteById(id);
    }
}
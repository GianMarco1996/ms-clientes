package com.bootcamp.customer.service;

import com.bootcamp.customer.model.Customer;
import com.bootcamp.customer.model.CustomerDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {
    Flux<CustomerDTO> getCustomers();
    Mono<CustomerDTO> getCustomer(String id);
    Mono<Customer> registerCustomer(Mono<Customer> customer);
    Mono<Customer> updateCustomer(String id, Mono<Customer> customer);
    Mono<Void> removeCustomer(String id);
}
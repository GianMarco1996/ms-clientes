package com.bootcamp.customer.service;

import com.bootcamp.customer.model.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {
    Flux<Customer> getCustomers();
    Mono<Customer> getCustomer(String id);
    Mono<Customer> registerCustomer(Mono<Customer> customer);
    Mono<Customer> updateCustomer(String id, Mono<Customer> customer);
    Mono<Void> removeCustomer(String id);
}
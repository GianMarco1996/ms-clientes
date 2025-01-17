package com.bootcamp.customer.controller;

import com.bootcamp.customer.api.CustomerApi;
import com.bootcamp.customer.mapper.CustomerMapper;
import com.bootcamp.customer.model.CustomerRequest;
import com.bootcamp.customer.model.CustomerResponse;
import com.bootcamp.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CustomerController implements CustomerApi {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Mono<ResponseEntity<CustomerResponse>> getCustomer(String id, ServerWebExchange exchange) {
        return customerService.getCustomer(id)
                .map(customer -> customerMapper.dtoToModel(customer))
                .map(ResponseEntity::ok);
    }

    @Override
    public Mono<ResponseEntity<Flux<CustomerResponse>>> getCustomers(ServerWebExchange exchange) {
        return Mono.just(ResponseEntity.ok().body(customerService.getCustomers()
                .map(customer -> customerMapper.dtoToModel(customer))));
    }

    @Override
    public Mono<ResponseEntity<Object>> registerCustomer(Mono<CustomerRequest> customerRequest, ServerWebExchange exchange) {
        return customerService.registerCustomer(
                        customerRequest.map(customer -> customerMapper.modelToDocument(customer)))
                .map(ResponseEntity::ok);
    }

    @Override
    public Mono<ResponseEntity<Void>> removeCustomer(String id, ServerWebExchange exchange) {
        return customerService.removeCustomer(id)
                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public Mono<ResponseEntity<Object>> updateCustomer(String id, Mono<CustomerRequest> customerRequest, ServerWebExchange exchange) {
        return customerService.updateCustomer(id,
                        customerRequest.map(customer -> customerMapper.modelToDocument(customer)))
                .map(ResponseEntity::ok);
    }

}
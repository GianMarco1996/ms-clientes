package com.bootcamp.customer.mapper;

import com.bootcamp.customer.model.Customer;
import com.bootcamp.customer.model.CustomerRequest;
import com.bootcamp.customer.model.CustomerResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper implements EntityMapper<Customer, CustomerResponse, CustomerRequest> {

    @Override
    public CustomerResponse toModel(Customer domain) {
        CustomerResponse customer = new CustomerResponse();
        BeanUtils.copyProperties(domain, customer);
        return customer;
    }

    @Override
    public Customer toDocument(CustomerRequest model) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(model, customer);
        return customer;
    }
}
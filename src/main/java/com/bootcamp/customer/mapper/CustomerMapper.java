package com.bootcamp.customer.mapper;

import com.bootcamp.customer.model.*;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerDTO documentToDto(Customer document) {
        CustomerDTO customer = new CustomerDTO();
        customer.setId(document.getId());
        customer.setType(document.getType());
        customer.setCompanyName(document.getCompanyName());
        customer.setRuc(document.getRuc());
        customer.setPhone(document.getPhone());
        customer.setAddress(document.getAddress());
        return customer;
    }

    public CustomerResponse dtoToModel(CustomerDTO dto) {
        CustomerResponse customer = new CustomerResponse();
        customer.setId(dto.getId());
        customer.setType(dto.getType());
        customer.setCompanyName(dto.getCompanyName());
        customer.setRuc(dto.getRuc());
        customer.setPhone(dto.getPhone());
        customer.setAddress(dto.getAddress());
        customer.setPersons(dto.getPersons().stream().map(this::dtoPersonToModel).toList());
        return customer;
    }

    public Customer modelToDocument(CustomerRequest model) {
        Customer customer = new Customer();
        customer.setType(model.getType());
        customer.setCompanyName(model.getCompanyName());
        customer.setRuc(model.getRuc());
        customer.setPhone(model.getPhone());
        customer.setAddress(model.getAddress());
        return customer;
    }

    private CustomerPersonResponse dtoPersonToModel(PersonResponse dto) {
        CustomerPersonResponse person = new CustomerPersonResponse();
        person.setName(dto.getName());
        person.setLastName(dto.getLastName());
        person.setTypePerson(dto.getTypePerson());
        person.setMobile(dto.getMobile());
        person.setEmail(dto.getEmail());
        person.setDocumentNumber(dto.getDocumentNumber());
        person.setDocumentType(dto.getDocumentType());
        person.setAddress(dto.getAddress());
        person.setBirthdate(dto.getBirthdate());
        person.setCustomerId(dto.getCustomerId());
        return person;
    }
}
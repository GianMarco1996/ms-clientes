package com.bootcamp.customer.model;

import lombok.Data;

@Data
public class PersonResponse {
    private String id;
    private String name;
    private String lastName;
    private String typePerson;
    private String mobile;
    private String email;
    private String documentNumber;
    private String documentType;
    private String address;
    private String birthdate;
    private String customerId;
}
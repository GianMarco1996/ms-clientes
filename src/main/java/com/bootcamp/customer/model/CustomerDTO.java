package com.bootcamp.customer.model;

import lombok.Data;

import java.util.List;

@Data
public class CustomerDTO {
    private String id;
    private String type;
    private String companyName;
    private String ruc;
    private String phone;
    private String address;
    private List<PersonResponse> persons;
}
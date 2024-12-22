package com.bootcamp.customer.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "customers")
public class Customer {
    @Id
    private String id;
    private String type;
    private String companyName;
    private String ruc;
    private String phone;
    private String address;
}
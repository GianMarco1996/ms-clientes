package com.bootcamp.customer.client;

import com.bootcamp.customer.model.PersonResponse;
import reactor.core.publisher.Flux;

public interface PersonClient {
    Flux<PersonResponse> getPersons();
}
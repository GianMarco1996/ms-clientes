package com.bootcamp.customer.client;

import com.bootcamp.customer.model.PersonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class PersonClientImpl implements PersonClient{

    private final WebClient.Builder webClientBuilder;

    @Autowired
    public PersonClientImpl(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    @Override
    public Flux<PersonResponse> getPersons() {
        return webClientBuilder.baseUrl("http://localhost:8082")
                .build()
                .get()
                .uri("/person/list")
                .retrieve()
                .bodyToFlux(PersonResponse.class);
    }
}

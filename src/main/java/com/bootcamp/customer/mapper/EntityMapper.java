package com.bootcamp.customer.mapper;

public interface EntityMapper<D, E, F> {
    E toModel(D model);
    D toDocument(F domain);
}
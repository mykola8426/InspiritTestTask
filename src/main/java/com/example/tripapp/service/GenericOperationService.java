package com.example.tripapp.service;

import java.util.List;

public interface GenericOperationService <E>{
    List<E> getAll();

    E add(E entity);

    E get(Long id);

    E update(E entity,Long id);

    void delete(Long id);
}

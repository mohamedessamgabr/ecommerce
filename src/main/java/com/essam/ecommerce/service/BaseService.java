package com.essam.ecommerce.service;

import java.util.List;

public interface BaseService<P, D> {
    D save(P p);
    void delete(P p);
    void deleteById(Integer id);
    List<D> findAll();
    D findById(Integer id);
    D update(Integer id, P p);
}

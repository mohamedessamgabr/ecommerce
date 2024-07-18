package com.essam.ecommerce.controller;

import com.essam.ecommerce.service.BaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

abstract class SimpleCrudController <P, D, S extends BaseService<P, D>> {

    private final S service;
    protected SimpleCrudController(S service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<D>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<D> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<D> save(@RequestBody P payload) {
        return ResponseEntity.ok(service.save(payload));
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.ok("Deleted Successfully");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<D> update(@PathVariable Integer id, @RequestBody P payload) {
        return ResponseEntity.ok(service.update(id, payload));
    }
}

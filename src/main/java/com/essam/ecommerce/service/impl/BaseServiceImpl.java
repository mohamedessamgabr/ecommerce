package com.essam.ecommerce.service.impl;

import com.essam.ecommerce.entity.BaseEntity;
import com.essam.ecommerce.mapper.BaseMapper;
import com.essam.ecommerce.service.BaseService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl<E extends BaseEntity, P, D,
        M extends BaseMapper<E, P, D>,
        R extends JpaRepository<E, Integer>> implements BaseService<P, D> {
    protected final R repository;
    private final M mapper;
    protected BaseServiceImpl(R repository, M mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public D save(P p) {
        return mapper.toDTO(repository.save(mapper.toEntity(p)));
    }

    @Override
    public void delete(P p) {
        repository.delete(mapper.toEntity(p));
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<D> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }
    @Override
    public D findById(Integer id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElse(null);
    }

    @Override
    public D update(Integer id, P p) {
        Optional<E> entity = repository.findById(id);
        if (entity.isPresent()) {
            return save(p);
        } else {
            throw new EntityNotFoundException("Not found entity with id " + id);
        }
    }
}

package com.essam.ecommerce.mapper;

import com.essam.ecommerce.entity.BaseEntity;

public interface BaseMapper<E, P, D> {
    E toEntity(P p);
    P toPayload(E e);
    D toDTO(E e);
}

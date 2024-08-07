package com.fiap.tc.infrastructure.adapter.persistence.mapper.base;

import org.mapstruct.InheritInverseConfiguration;

public interface MapperEntity<E, D> {

    E toEntity(D dto);

    @InheritInverseConfiguration
    D fromEntity(E entity);
}

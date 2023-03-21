package com.apiPartidos.api_partidos.Repositories;

import com.apiPartidos.api_partidos.Data.entidades.EquipoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEquipoRepository extends CrudRepository<EquipoEntity, Long> {
    public EquipoEntity findById(long id);
}

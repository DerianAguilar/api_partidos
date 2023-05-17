package com.apiPartidos.api_partidos.data.repositorios;

import com.apiPartidos.api_partidos.data.entidades.EquipoEntity;
import org.springframework.data.repository.CrudRepository;


public interface IEquipoRepository extends CrudRepository<EquipoEntity, Long>{
    
    EquipoEntity findById(long id);

}

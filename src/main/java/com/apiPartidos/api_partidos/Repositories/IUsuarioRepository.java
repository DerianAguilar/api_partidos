package com.apiPartidos.api_partidos.Repositories;

import com.apiPartidos.api_partidos.Data.entidades.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends CrudRepository<UsuarioEntity, Long> {

    public UsuarioEntity findByEmail(String email);
    public UsuarioEntity findByUsername(String username);
}

package com.apiPartidos.api_partidos.data.repositorios;

import com.apiPartidos.api_partidos.data.entidades.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioRepository extends CrudRepository<UsuarioEntity, Long> {
    
   public UsuarioEntity findByEmail(String email);
   public UsuarioEntity findByUsername(String username);
   


}

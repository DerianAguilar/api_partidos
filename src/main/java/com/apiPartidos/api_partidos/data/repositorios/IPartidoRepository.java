package com.apiPartidos.api_partidos.data.repositorios;

import com.apiPartidos.api_partidos.data.entidades.PartidoEntity;
import com.apiPartidos.api_partidos.data.entidades.UsuarioEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface IPartidoRepository extends PagingAndSortingRepository<PartidoEntity, Long>{
    
    public List<PartidoEntity> findByUsuarioEntityOrderByCreadoDesc(UsuarioEntity usuarioEntity);

    @Query(nativeQuery = true, value = "SELECT * FROM partido ORDER BY creado DESC LIMIT 10")
    public List<PartidoEntity> partidosCreados();

    public PartidoEntity findByIdPartido(String id);

}

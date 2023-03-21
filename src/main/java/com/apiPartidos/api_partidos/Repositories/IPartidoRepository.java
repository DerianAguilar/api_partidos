package com.apiPartidos.api_partidos.Repositories;

import com.apiPartidos.api_partidos.Data.entidades.PartidoEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPartidoRepository extends PagingAndSortingRepository<PartidoEntity, Long> {
}

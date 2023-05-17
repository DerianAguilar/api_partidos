package com.apiPartidos.api_partidos.services;

import com.apiPartidos.api_partidos.shared.PartidoDto;

import java.util.List;

public interface IPartidoService {
    
    public PartidoDto crearPartido(PartidoDto partidoCrearDto);

    public List<PartidoDto> partidosCreados();

    public PartidoDto detallePartido(String id);

    public PartidoDto actualizarPartido(String idPartido, PartidoDto partidoActualizarDto);

    void eliminarPartido(String idPartido, long idUsuario);
}

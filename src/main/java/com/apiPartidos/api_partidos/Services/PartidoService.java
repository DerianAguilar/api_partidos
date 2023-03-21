package com.apiPartidos.api_partidos.Services;

import com.apiPartidos.api_partidos.Data.entidades.EquipoEntity;
import com.apiPartidos.api_partidos.Data.entidades.PartidoEntity;
import com.apiPartidos.api_partidos.Data.entidades.UsuarioEntity;
import com.apiPartidos.api_partidos.Repositories.IEquipoRepository;
import com.apiPartidos.api_partidos.Repositories.IPartidoRepository;
import com.apiPartidos.api_partidos.Repositories.IUsuarioRepository;
import com.apiPartidos.api_partidos.Shared.PartidoDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PartidoService implements IPartidoService{

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IUsuarioRepository iUsuarioRepository;
    @Autowired
    private IEquipoRepository iEquipoRepository;
    @Autowired
    private IPartidoRepository iPartidoRepository;

    @Override
    public PartidoDto crearPartido(PartidoDto partidoCrearDto) {

        UsuarioEntity usuarioEntity = iUsuarioRepository.findByUsername(partidoCrearDto.getUsername());

        EquipoEntity equipoEntityLocal = iEquipoRepository.findById(partidoCrearDto.getEquipoLocal());

        EquipoEntity equipoEntityVisitante = iEquipoRepository.findById(partidoCrearDto.getEquipoVisitante());

        PartidoEntity partidoEntity = new PartidoEntity();
        partidoEntity.setIdPartido(UUID.randomUUID().toString());
        partidoEntity.setFecha(partidoCrearDto.getFecha());
        partidoEntity.setGolesLocal("0");
        partidoEntity.setGolesVisitante("0");
        partidoEntity.setUsuarioEntity(usuarioEntity);
        partidoEntity.setEquipoEntityLocal(equipoEntityLocal);
        partidoEntity.setEquipoEntityVisitante(equipoEntityVisitante);

        PartidoEntity partidoCreado = iPartidoRepository.save(partidoEntity);

        PartidoDto partidoDto = modelMapper.map(partidoCreado, PartidoDto.class);

        return partidoDto;
    }
}

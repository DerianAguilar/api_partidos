package com.apiPartidos.api_partidos.controllers;

import com.apiPartidos.api_partidos.models.peticiones.UsuarioCrearRequestModel;
import com.apiPartidos.api_partidos.models.respuestas.PartidoDataRestModel;
import com.apiPartidos.api_partidos.models.respuestas.UsuarioDataRestModel;
import com.apiPartidos.api_partidos.services.IUsuarioService;
import com.apiPartidos.api_partidos.shared.PartidoDto;
import com.apiPartidos.api_partidos.shared.UsuarioDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/usuario")

public class UsuarioController {

    
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IUsuarioService iUsuarioService;

    @GetMapping
    public UsuarioDataRestModel leerUsuario(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username= authentication.getPrincipal().toString();

        UsuarioDto usuarioDto = iUsuarioService.leerUsuario(username);

        UsuarioDataRestModel usuarioDataRestModel= modelMapper.map(usuarioDto, UsuarioDataRestModel.class);

        return usuarioDataRestModel;

    }

    @GetMapping("/misPartidos")
    public List<PartidoDataRestModel> leerMisPartidos(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username= authentication.getPrincipal().toString();

        List<PartidoDto> partidoDtoList = iUsuarioService.verMisPartidos(username);

        List<PartidoDataRestModel> partidoDataRestModelList = new ArrayList<>();

        for(PartidoDto partidoDto : partidoDtoList){

            PartidoDataRestModel partidoDataRestModel = modelMapper.map(partidoDto, PartidoDataRestModel.class);
            partidoDataRestModelList.add(partidoDataRestModel);

        }

        return partidoDataRestModelList;

    }

    @PostMapping
    public UsuarioDataRestModel crearUsuario(@RequestBody UsuarioCrearRequestModel usuarioCrearRequestModel){
        
        UsuarioDto usuarioCrearDto = modelMapper.map(usuarioCrearRequestModel, UsuarioDto.class);
        
        UsuarioDto usuarioDto= iUsuarioService.crearUsuario(usuarioCrearDto);

        UsuarioDataRestModel usuarioDataRestModel= modelMapper.map(usuarioDto, UsuarioDataRestModel.class);

        return usuarioDataRestModel;
    }

}

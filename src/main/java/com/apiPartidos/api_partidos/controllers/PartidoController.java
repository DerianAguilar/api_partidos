package com.apiPartidos.api_partidos.controllers;

import com.apiPartidos.api_partidos.models.peticiones.PartidoActualizarRequestModel;
import com.apiPartidos.api_partidos.models.peticiones.PartidoCrearRequesModel;
import com.apiPartidos.api_partidos.models.respuestas.MensajeRestModel;
import com.apiPartidos.api_partidos.models.respuestas.PartidoDataRestModel;
import com.apiPartidos.api_partidos.services.IPartidoService;
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
@RequestMapping("/partido")
public class PartidoController {
    
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IPartidoService iPartidoService;

    @Autowired
    IUsuarioService iUsuarioService;

    @GetMapping
    public List<PartidoDataRestModel> partidosCreados(){

        List<PartidoDataRestModel> partidoDataRestModelList = new ArrayList<>();

        List<PartidoDto> partidoDtoList = iPartidoService.partidosCreados();

        for (PartidoDto partidoDto : partidoDtoList){

            PartidoDataRestModel partidoDataRestModel = modelMapper.map(partidoDto, PartidoDataRestModel.class);
            partidoDataRestModelList.add(partidoDataRestModel);

        }

        return partidoDataRestModelList;

    }

    @GetMapping(path = "/{id}")
    public  PartidoDataRestModel detallePartido(@PathVariable("id") String id){

        PartidoDto partidoDto = iPartidoService.detallePartido(id);

        PartidoDataRestModel partidoDataRestModel = modelMapper.map(partidoDto, PartidoDataRestModel.class);

        return partidoDataRestModel;

    }

    @PostMapping
    public PartidoDataRestModel crearPartido(@RequestBody PartidoCrearRequesModel partidoCrearRequesModel){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username= authentication.getPrincipal().toString();

        PartidoDto partidoCrearDto= modelMapper.map(partidoCrearRequesModel, PartidoDto.class);
        partidoCrearDto.setUsername(username);

        PartidoDto partidoDto= iPartidoService.crearPartido(partidoCrearDto);

        PartidoDataRestModel partidoDataRestModel = modelMapper.map(partidoDto, PartidoDataRestModel.class);

        return partidoDataRestModel;
    }

    @PutMapping(path = "/{id}")
    public PartidoDataRestModel actualizarPartido(@PathVariable("id")String id ,@RequestBody PartidoActualizarRequestModel partidoActualizarRequestModel){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username= authentication.getPrincipal().toString();

        PartidoDto partidoDtoActializar = modelMapper.map(partidoActualizarRequestModel, PartidoDto.class);
        partidoDtoActializar.setUsername(username);

        PartidoDto partidoDto = iPartidoService.actualizarPartido(id, partidoDtoActializar);

        PartidoDataRestModel partidoDataRestModel = modelMapper.map(partidoDto, PartidoDataRestModel.class);

        return partidoDataRestModel;

    }

    @DeleteMapping(path = "/{id}")
    public MensajeRestModel eliminarPartido(@PathVariable("id") String id){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username= authentication.getPrincipal().toString();

        UsuarioDto usuarioDto = iUsuarioService.leerUsuario(username);

        MensajeRestModel mensajeRestModel = new MensajeRestModel();
        mensajeRestModel.setNombre("Eliminar");

        iPartidoService.eliminarPartido(id, usuarioDto.getId());

        mensajeRestModel.setResultado("Partido eliminado con éxito");

        return mensajeRestModel;

    }
    
}

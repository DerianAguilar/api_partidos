package com.apiPartidos.api_partidos.Controllers;

import com.apiPartidos.api_partidos.Models.peticiones.PartidoCrearRequestModel;
import com.apiPartidos.api_partidos.Models.respuestas.PartidoDataRestModel;
import com.apiPartidos.api_partidos.Services.IPartidoService;
import com.apiPartidos.api_partidos.Shared.PartidoDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/partido")
public class PartidoController {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IPartidoService iPartidoService;

    @PostMapping
    public PartidoDataRestModel crearPartido(@RequestBody PartidoCrearRequestModel partidoCrearRequestModel){

        String username= "rortegani";

        PartidoDto partidoCrearDto = modelMapper.map(partidoCrearRequestModel, PartidoDto.class);
        partidoCrearDto.setUsername(username);

        PartidoDto partidoDto = iPartidoService.crearPartido(partidoCrearDto);

        PartidoDataRestModel partidoDataRestModel = modelMapper.map(partidoDto, PartidoDataRestModel.class);
        return partidoDataRestModel;
    }
}

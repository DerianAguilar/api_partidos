package com.apiPartidos.api_partidos.services;

import com.apiPartidos.api_partidos.shared.PartidoDto;
import com.apiPartidos.api_partidos.shared.UsuarioDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUsuarioService extends UserDetailsService {

    public UsuarioDto crearUsuario(UsuarioDto usuarioCrearDto);
    public UsuarioDto leerUsuario(String username);
    public List<PartidoDto> verMisPartidos(String username);

}

package com.apiPartidos.api_partidos.Services;

import com.apiPartidos.api_partidos.Shared.UsuarioDto;

public interface IUsuarioService {

    public UsuarioDto crearUsuario (UsuarioDto usuarioDto);
    public UsuarioDto leerUsuario (String username);
}

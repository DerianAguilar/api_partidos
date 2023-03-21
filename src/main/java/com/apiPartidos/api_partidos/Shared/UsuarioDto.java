package com.apiPartidos.api_partidos.Shared;

import java.io.Serializable;
import java.util.List;

public class UsuarioDto implements Serializable {

    private static final long serialVersionUID=1L;

    private long id;
    private String idUsuario;
    private String nombre;
    private String email;
    private String username;
    private String password;
    private String passwordEncriptada;
    private List<PartidoDto> partidoDtoList;

    public UsuarioDto() {
    }

    public UsuarioDto(long id, String idUsuario, String nombre, String email, String username, String password, String passwordEncriptada) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.email = email;
        this.username = username;
        this.password = password;
        this.passwordEncriptada = passwordEncriptada;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordEncriptada() {
        return passwordEncriptada;
    }

    public void setPasswordEncriptada(String passwordEncriptada) {
        this.passwordEncriptada = passwordEncriptada;
    }

    public List<PartidoDto> getPartidoDtoList() {
        return partidoDtoList;
    }

    public void setPartidoDtoList(List<PartidoDto> partidoDtoList) {
        this.partidoDtoList = partidoDtoList;
    }
}

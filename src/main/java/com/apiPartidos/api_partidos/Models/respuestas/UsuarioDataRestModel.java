package com.apiPartidos.api_partidos.Models.respuestas;

import java.util.List;

public class UsuarioDataRestModel {

    private String idUsuario;
    private String nombre;
    private String email;
    private String username;
    private List<PartidoDataRestModel> partidoDataRestModelList;

    public UsuarioDataRestModel() {
    }

    public UsuarioDataRestModel(String idUsuario, String nombre, String email, String username) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.email = email;
        this.username = username;
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

    public List<PartidoDataRestModel> getPartidoDataRestModelList() {
        return partidoDataRestModelList;
    }

    public void setPartidoDataRestModelList(List<PartidoDataRestModel> partidoDataRestModelList) {
        this.partidoDataRestModelList = partidoDataRestModelList;
    }
}

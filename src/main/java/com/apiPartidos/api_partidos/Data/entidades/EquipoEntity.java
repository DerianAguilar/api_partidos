package com.apiPartidos.api_partidos.Data.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "equipo")
public class EquipoEntity implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 20)
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipoEntityLocal")
    private List<PartidoEntity> partidoEntityLocalList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipoEntityVisitante")
    private List<PartidoEntity> partidoEntityVisitanteList = new ArrayList<>();

    public EquipoEntity() {
    }

    public EquipoEntity(long id, String nombre, List<PartidoEntity> partidoEntityLocalList, List<PartidoEntity> partidoEntityVisitanteList) {
        this.id = id;
        this.nombre = nombre;
        this.partidoEntityLocalList = partidoEntityLocalList;
        this.partidoEntityVisitanteList = partidoEntityVisitanteList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<PartidoEntity> getPartidoEntityLocalList() {
        return partidoEntityLocalList;
    }

    public void setPartidoEntityLocalList(List<PartidoEntity> partidoEntityLocalList) {
        this.partidoEntityLocalList = partidoEntityLocalList;
    }

    public List<PartidoEntity> getPartidoEntityVisitanteList() {
        return partidoEntityVisitanteList;
    }

    public void setPartidoEntityVisitanteList(List<PartidoEntity> partidoEntityVisitanteList) {
        this.partidoEntityVisitanteList = partidoEntityVisitanteList;
    }
}

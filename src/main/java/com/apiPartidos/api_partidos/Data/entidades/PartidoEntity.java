package com.apiPartidos.api_partidos.Data.entidades;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "partido")
@EntityListeners(AuditingEntityListener.class)
@Table(indexes = {
        @Index(columnList = "idPartido", name = "index_idPartido", unique = true)
})
public class PartidoEntity implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String idPartido;
    @Column(nullable = false)
    private Date fecha;
    @Column(nullable = false)
    private String golesLocal;
    @Column(nullable = false)
    private String golesVisitante;

    @CreatedDate
    private Date creado;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuarioEntity;
    @ManyToOne
    @JoinColumn(name = "id_equipolocal")
    private EquipoEntity equipoEntityLocal;
    @ManyToOne
    @JoinColumn(name = "id_equipovisitante")
    private EquipoEntity equipoEntityVisitante;

    public PartidoEntity() {
    }

    public PartidoEntity(long id, String idPartido, Date fecha, String golesLocal, String golesVisitante, Date creado, UsuarioEntity usuarioEntity, EquipoEntity equipoEntityLocal, EquipoEntity equipoEntityVisitante) {
        this.id = id;
        this.idPartido = idPartido;
        this.fecha = fecha;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
        this.creado = creado;
        this.usuarioEntity = usuarioEntity;
        this.equipoEntityLocal = equipoEntityLocal;
        this.equipoEntityVisitante = equipoEntityVisitante;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(String idPartido) {
        this.idPartido = idPartido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(String golesLocal) {
        this.golesLocal = golesLocal;
    }

    public String getGolesVisitante() {
        return golesVisitante;
    }

    public void setGolesVisitante(String golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

    public Date getCreado() {
        return creado;
    }

    public void setCreado(Date creado) {
        this.creado = creado;
    }

    public UsuarioEntity getUsuarioEntity() {
        return usuarioEntity;
    }

    public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
        this.usuarioEntity = usuarioEntity;
    }

    public EquipoEntity getEquipoEntityLocal() {
        return equipoEntityLocal;
    }

    public void setEquipoEntityLocal(EquipoEntity equipoEntityLocal) {
        this.equipoEntityLocal = equipoEntityLocal;
    }

    public EquipoEntity getEquipoEntityVisitante() {
        return equipoEntityVisitante;
    }

    public void setEquipoEntityVisitante(EquipoEntity equipoEntityVisitante) {
        this.equipoEntityVisitante = equipoEntityVisitante;
    }
}

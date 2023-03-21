package com.apiPartidos.api_partidos.Models.peticiones;

import java.util.Date;

public class PartidoCrearRequestModel {

    private Date fecha;
    private String equipoLocal;
    private String equipoVisitante;

    public PartidoCrearRequestModel() {
    }

    public PartidoCrearRequestModel(Date fecha, String equipoLocal, String equipoVisitante) {
        this.fecha = fecha;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(String equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(String equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }
}

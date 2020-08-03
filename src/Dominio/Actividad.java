/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author gabrielflores
 */
public class Actividad {
    private int idActividad;
    private String nombreActividad;
    private String nombreTema;
    private int idTema;
    private int idAvance;
    private String porcentajeAvance;
    private String observaciones;

    public Actividad(int idActividad, String nombreActividad, String nombreTema, int idTema, int idAvance, String porcentajeAvance, String observaciones) {
        this.idActividad = idActividad;
        this.nombreActividad = nombreActividad;
        this.nombreTema = nombreTema;
        this.idTema = idTema;
        this.idAvance = idAvance;
        this.porcentajeAvance = porcentajeAvance;
        this.observaciones = observaciones;
    }
    
    public Actividad() {}

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public int getIdTema() {
        return idTema;
    }

    public void setIdTema(int idTema) {
        this.idTema = idTema;
    }

    public String getNombreTema() {
        return nombreTema;
    }

    public void setNombreTema(String nombreTema) {
        this.nombreTema = nombreTema;
    }

    public int getIdAvance() {
        return idAvance;
    }

    public void setIdAvance(int idAvance) {
        this.idAvance = idAvance;
    }

    public String getPorcentajeAvance() {
        return porcentajeAvance;
    }

    public void setPorcentajeAvance(String porcentajeAvance) {
        this.porcentajeAvance = porcentajeAvance;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    
}

package Dominio;

import java.util.Date;

public class Tema {
    private int idTema;
    private String nombreTema;
    private Date fechaEstablecida;
    private Date fechaFinTema;
    private int idPlan;
    private int idAvance;
    private String porcentajeAvance;
    private String observaciones;

    public Tema(int idTema, String nombreTema, Date fechaEstablecida, Date fechaFinTema, int idPlan, int idAvance, String porcentajeAvance, String observaciones) {
        this.idTema = idTema;
        this.nombreTema = nombreTema;
        this.fechaEstablecida = fechaEstablecida;
        this.fechaFinTema = fechaFinTema;
        this.idPlan = idPlan;
        this.idAvance = idAvance;
        this.porcentajeAvance = porcentajeAvance;
        this.observaciones = observaciones;
    }

    public Tema() {
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

    public Date getFechaEstablecida() {
        return fechaEstablecida;
    }

    public void setFechaEstablecida(Date fechaEstablecida) {
        this.fechaEstablecida = fechaEstablecida;
    }

    public int getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(int idPlan) {
        this.idPlan = idPlan;
    }

    public Date getFechaFinTema() {
        return fechaFinTema;
    }

    public void setFechaFinTema(Date fechaFinTema) {
        this.fechaFinTema = fechaFinTema;
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

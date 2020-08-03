/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.Date;

/**
 *
 * @author gabrielflores
 */
public class PlanDeCurso {
    
    int idPlan;
    String nombreCurso;
    Date fechaInicio;
    Date fechaFin;
    String NRCCurso;
    
    public PlanDeCurso (String nombreCurso, Date fechaInicio, Date fechaFin, String NRCCurso) {
        this.nombreCurso = nombreCurso;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.NRCCurso = NRCCurso;
    }

    public PlanDeCurso() {
    }
    
    public Date getFechaInicio(){
        return fechaInicio;
    }
    
    public void setFechaInicio(Date fechaInicio){
        this.fechaInicio = fechaInicio;
    }
    
    public Date getFechaFin(){
        return fechaFin;
    }
    
    public void setFechaFin(Date fechaFin){
        this.fechaFin = fechaFin;
    }
    
    public int getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(int idPlan) {
        this.idPlan = idPlan;
    }

    public String getNRCCurso() {
        return NRCCurso;
    }

    public void setNRCCurso(String NRCCurso) {
        this.NRCCurso = NRCCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }
    
}

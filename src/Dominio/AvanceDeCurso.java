package Dominio;

import java.util.Date;


public class AvanceDeCurso {
    int idAvance;
    Date fechaAvance;
    int idPlan;
    String NRCCurso;
    
    public AvanceDeCurso(){}

    public AvanceDeCurso(int idAvance, Date fechaAvance, int idPlan) {
        this.idAvance = idAvance;
        this.fechaAvance = fechaAvance;
        this.idPlan = idPlan;
    }
    
    public AvanceDeCurso(Date fechaAvance, int idPlan, String NRCCurso) {
        this.fechaAvance = fechaAvance;
        this.idPlan = idPlan;
        this.NRCCurso = NRCCurso;
    }
    
    public Date getFechaAvance(){
        return fechaAvance;
    }
    
    public void setFechaAvance(Date fechaAvance){
        this.fechaAvance = fechaAvance;
    }

    public int getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(int idPlan) {
        this.idPlan = idPlan;
    }

    public int getIdAvance() {
        return idAvance;
    }

    public void setIdAvance(int idAvance) {
        this.idAvance = idAvance;
    }

    public String getNRCCurso() {
        return NRCCurso;
    }

    public void setNRCCurso(String NRCCurso) {
        this.NRCCurso = NRCCurso;
    }
    
}

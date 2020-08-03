package Dominio;


public class Curso {
    String nrc;
    String nombre;
    String periodo;
    String turno;
    String numeroDePersonal;
    String nombreCatalogo;
    int estado;
    
    public Curso () {}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getNrc() {
        return nrc;
    }

    public void setNrc(String nrc) {
        this.nrc = nrc;
    }
    
    public String getNumeroDePersonal(){
        return numeroDePersonal;
    }
    
    public void setNumeroDePersonal(String numeroDePersonal){
        this.numeroDePersonal = numeroDePersonal;
    }
    
    public String getNombreCatalogo(){
        return nombreCatalogo;
    }
    
    public void setNombreCatalogo(String nombreCatalogo){
        this.nombreCatalogo = nombreCatalogo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
}

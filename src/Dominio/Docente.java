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
public class Docente {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correo;
    private Date fechaNacimiento;
    private String sexo;
    private String numPersonal;
    private String rfc;
    private String curp;
    private String contraseña;
    
    
    public Docente () {}
    public Docente (String numPersonal, String nombre, String apellidoMaterno, String apellidoPaterno, String curp, String rfc, String fechaNacimiento, String sexo, String contraseña, String correo) {
    this.nombre = nombre;
    this.apellidoMaterno = apellidoMaterno;
    this.apellidoPaterno = apellidoPaterno;
    this.correo = correo;
    this.sexo = sexo;
    this.numPersonal = numPersonal;
    this.rfc = rfc;
    this.curp = curp;
    this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNumPersonal() {
        return numPersonal;
    }

    public void setNumPersonal(String numPersonal) {
        this.numPersonal = numPersonal;
    }
    public String getRfc(){
        return rfc;
    }
    public void setRfc (String rfc){
        this.rfc = rfc;
    }
    
    public String getCurp(){
        return curp;
    }
    public void setCurp(String curp){
        this.curp = curp;
    }
    
    public String getContraseña(){
        return contraseña;
    }
    public void setContraseña(String contraseña){
        this.contraseña = contraseña;
    }
    
    
    
}

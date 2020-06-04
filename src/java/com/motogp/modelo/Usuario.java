/*
 * To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.motogp.modelo;


/**
 *
 * @author Maria Camila
 */
public class Usuario {
   short idPiloto;
   String nombre;
   String identificacion;
   String nacionalidad;
   short idMoto;
   String tipoMoto;
   String colorMoto;
   String cilindraje;
   String tiempoClasificacion;
   String correo;
   String contrasenia;

   public Usuario() {      

   }

    public Usuario(short idPiloto,String nombre,String identificacion,String nacionalidad,short idMoto,String tipoMoto,String colorMoto,String cilindraje,String tiempoClasificacion) {
   this.idPiloto= idPiloto;
   this.nombre = nombre;
   this.identificacion = identificacion;
   this.nacionalidad = nacionalidad;
   this.idMoto = idMoto;
   this.tipoMoto = tipoMoto;
   this.colorMoto = colorMoto;
   this.cilindraje = cilindraje;
   this.tiempoClasificacion = tiempoClasificacion;    
//To change body of generated methods, choose Tools | Templates.
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
       
    public short getIdPiloto() {
        return idPiloto;
    }

    public void setIdPiloto(short idPiloto) {
        this.idPiloto = idPiloto;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public short getIdMoto() {
        return idMoto;
    }

    public void setIdMoto(short idMoto) {
        this.idMoto = idMoto;
    }

    public String getTipoMoto() {
        return tipoMoto;
    }

    public void setTipoMoto(String tipoMoto) {
        this.tipoMoto = tipoMoto;
    }

    public String getColorMoto() {
        return colorMoto;
    }

    public void setColorMoto(String colorMoto) {
        this.colorMoto = colorMoto;
    }

    public String getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String getTiempoClasificacion() {
        return tiempoClasificacion;
    }

    public void setTiempoClasificacion(String tiempoClasificacion) {
        this.tiempoClasificacion = tiempoClasificacion;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + '}';
    }
   
    
}

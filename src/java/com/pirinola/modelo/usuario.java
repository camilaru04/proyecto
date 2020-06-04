/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pirinola.modelo;

import java.io.Serializable;

/**
 *
 * @author Maria Camila
 */
public class usuario implements Serializable{
      private String nombre; //null
    private String email; //0
    private String password; //0

   
    public usuario() {
       
    }    
    
    public usuario(String nombre, String  email,String password ) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
 
}

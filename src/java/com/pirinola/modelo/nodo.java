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
public class nodo implements Serializable{
   private usuario dato;
    private nodo siguiente;
    private nodo anterior;

    public nodo(usuario dato) {
        this.dato = dato;
    }

    public usuario getDato() {
        return dato;
    }

    public void setDato(usuario dato) {
        this.dato = dato;
    }

    public nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(nodo siguiente) {
        this.siguiente = siguiente;
    }

    public nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(nodo anterior) {
        this.anterior = anterior;
    }
    
}

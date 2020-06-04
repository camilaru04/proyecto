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
public class NodoDE {
  private Usuario dato;
    private NodoDE siguiente;
    private NodoDE anterior;

    public NodoDE(Usuario dato) {
        this.dato = dato;
    }


    public Usuario getDato() {
        return dato;
    }

    public void setDato(Usuario dato) {
        this.dato = dato;
    }

    public NodoDE getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDE siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDE getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDE anterior) {
        this.anterior = anterior;
    }
         
}

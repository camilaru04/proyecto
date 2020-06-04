/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pirinola.modelo;

import com.motogp.excepciones.UsuarioExcepcion;
import java.io.Serializable;

/**
 *
 * @author Maria Camila
 */
public class lista implements Serializable{
   private nodo cabeza;

    public nodo getCabeza() {
        return cabeza;
    }

    public void setCabeza(nodo cabeza) {
        this.cabeza = cabeza;
    }
    
    
    
     public void adicionarNodo(usuario pirinola) {
        if (cabeza == null) {
            cabeza = new nodo(pirinola);
            ///Hago los enlaces circulares
            cabeza.setSiguiente(cabeza);
            cabeza.setAnterior(cabeza);
            
        } else {
            //Lamo a mi ayudante
           nodo temp= cabeza.getAnterior();
           //temp= temp.getAnterior();
           nodo nodoInsertar = new nodo(pirinola);
           temp.setSiguiente(nodoInsertar);
           nodoInsertar.setAnterior(temp);           
           nodoInsertar.setSiguiente(cabeza);
           cabeza.setAnterior(nodoInsertar);
        }
    }

    public void adicionarNodoAlInicio(usuario pirinola) {
        if (cabeza == null) {
             cabeza = new nodo(pirinola);
            ///Hago los enlaces circulares
            cabeza.setSiguiente(cabeza);
            cabeza.setAnterior(cabeza);
        } else {
            nodo temp= cabeza.getAnterior();
           //temp= temp.getAnterior();
           nodo nodoInsertar = new nodo(pirinola);
           temp.setSiguiente(nodoInsertar);
           nodoInsertar.setAnterior(temp);           
           nodoInsertar.setSiguiente(cabeza);
           cabeza.setAnterior(nodoInsertar);
           cabeza = cabeza.getAnterior();
        }
    }
    
    public short contarNodos()
    {
        if(cabeza ==null)
        {
            return 0;
        }
        else
        {
            //llamar a mi ayudante
            nodo temp= cabeza;
            short cont=1;
            while(temp.getSiguiente()!=cabeza)
            {
                temp=temp.getSiguiente();
                cont++;
            }
            return cont;
        }
    }
    
    
     public String listarInfantes(String listado) throws UsuarioExcepcion
     {
        if (cabeza != null) {
            nodo temp = cabeza;
//            while (temp.getSiguiente() != cabeza) {
//                listado += temp.getDato() + "\n";
//                temp = temp.getSiguiente();
//            }
//            listado += temp.getDato() + "\n";
            do
            {
                listado += temp.getDato() + "\n";
                temp = temp.getSiguiente();
            }while(temp != cabeza);

            return listado;
        }
        throw new UsuarioExcepcion(("No existen Usuario en la lista"));
    }
    
    //Eliminar NOdo
     
 
 }
  
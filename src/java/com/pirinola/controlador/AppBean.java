/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pirinola.controlador;

import com.motogpbs.controlador.util.JsfUtil;
import com.pirinola.modelo.lista;
import com.pirinola.modelo.nodo;
import com.pirinola.modelo.usuario;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author Maria Camila
 */
@Named(value = "appBean")
@ApplicationScoped
public class AppBean {
    
    private String correoTurno="mcrueda69848@umanizales.edu.co";    
    private  int cont=0;  
    
    private List<usuario> listadoUsuario;

    private usuario usuario;
   
   private usuario usuarioSeleccionado;
        
    private nodo ayudante;
    
    private lista listaCircular;
    
   private boolean verInicio=true;
      
    /**
     * Creates a new instance of AppBean
     */
    public AppBean() {
    }
    
    @PostConstruct
    public void inicializar()
    {
        listaCircular = new lista();
        //recorrer el listado y envio el infante a laista SE
        listadoUsuario.forEach((inf) -> {
            listaCircular.adicionarNodo(inf);
        });
        
        ayudante = listaCircular.getCabeza();
        usuarioSeleccionado = ayudante.getDato();       
        
    }

    public boolean isVerInicio() {
        return verInicio;
    }

    public void setVerInicio(boolean verInicio) {
        this.verInicio = verInicio;
    }
    
    public List<usuario> getListadoUsuario() {
        return listadoUsuario;
    }

    public void setListadoUsuario(List<usuario> listadoUsuario) {
        this.listadoUsuario = listadoUsuario;
    }

    public usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(usuario usuario) {
        this.usuario = usuario;
    }

    public usuario getUsuarioSeleccionado() {
        return usuarioSeleccionado;
    }

    public void setUsuarioSeleccionado(usuario usuarioSeleccionado) {
        this.usuarioSeleccionado = usuarioSeleccionado;
    }

    public lista getListaCircular() {
        return listaCircular;
    }

    public void setListaCircular(lista listaCircular) {
        this.listaCircular = listaCircular;
    }

    public String getCorreoTurno() {
        return correoTurno;
    }

    public void setCorreoTurno(String correoTurno) {
        this.correoTurno = correoTurno;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public void aumentarContador(String correo)
    {
        switch(correo)
        {
            case "carloaiza@umanizales.edu.co":
                correoTurno= "consulta@umanizales.edu.co";
                break;
            default:
                correoTurno= "carloaiza@umanizales.edu.co";
        }
        
        cont++;
    }
    
    public boolean validarTurno(String correo)
    {
        if(correo.equals(correoTurno))
        {
            return true;
        }
        return false;
    }
    
    
    public void moverRuleta()
    {        
       if(!verInicio)
       {
            ayudante = ayudante.getSiguiente();
            usuarioSeleccionado = ayudante.getDato();
       }
       
    }
    
    public void controlarCiclo()
    {
        //False fue por que va a parar
        if(!verInicio)
        {
            //Eliminaría el niño . Valido lo seleccionado
            for(usuario inf: listadoUsuario)
            {
                if(inf.getNombre() == usuarioSeleccionado.getNombre())
                {
                    listadoUsuario.remove(inf);
                    break;
                }
            }    
            
            if(listadoUsuario.size()==1)
            {
                JsfUtil.addSuccessMessage("Ha ganado "+listadoUsuario.get(0));
            }
            
        }    
        verInicio = !verInicio;
    }
    
    
}

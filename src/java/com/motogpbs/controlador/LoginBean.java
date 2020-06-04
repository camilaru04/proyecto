package com.motogpbs.controlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.motogpbs.controlador.util.JsfUtil;
import com.motogpbs.modelo.Usuario;
import static com.motogpbs.modelo.Usuario_.nombreCompleto;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import static java.time.Clock.system;
import javax.ejb.EJB;

/**
 *
 * @author carloaiza
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {
    
    private String Nombre;
    private String correo="mcrueda69848@umanizales.edu.co";
    private String contrasenia="123456";
    private Usuario usuarioAutenticado;
    @EJB
    private UsuarioFacade connUsuario;
    
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
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

    public Usuario getUsuarioAutenticado() {
        return usuarioAutenticado;
    }

    public void setUsuarioAutenticado(Usuario usuarioAutenticado) {
        this.usuarioAutenticado = usuarioAutenticado;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    
    public String ingresar()
    {
        Usuario usuencontrado = connUsuario.find(correo);
        if(usuencontrado!=null)
        {
            if(usuencontrado.getNombreCompleto().equals(nombreCompleto))
            {
                System.out.println("hola");
                usuarioAutenticado = usuencontrado;
                return "usuario/list.xhtml";
            }
        }
        JsfUtil.addErrorMessage("Error");        
        return null;
    }
    
}

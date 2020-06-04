/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.motogp.controlador;

import com.motogp.excepciones.UsuarioExcepcion;
import com.motogp.modelo.ListaDE;
import com.motogp.modelo.NodoDE;
import com.motogp.modelo.Usuario;
import com.motogp.utilidades.JsfUtil;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import org.primefaces.model.diagram.Connection;
import org.primefaces.model.diagram.DefaultDiagramModel;
import org.primefaces.model.diagram.DiagramModel;
import org.primefaces.model.diagram.Element;
import org.primefaces.model.diagram.connector.StateMachineConnector;
import org.primefaces.model.diagram.endpoint.BlankEndPoint;
import org.primefaces.model.diagram.endpoint.EndPoint;
import org.primefaces.model.diagram.endpoint.EndPointAnchor;
import org.primefaces.model.diagram.overlay.ArrowOverlay;
import org.primefaces.model.diagram.overlay.LabelOverlay;


/**
 *
 * @author Maria Camila
 */
@Named(value = "sesionUsuario")
@SessionScoped
public class SesionUsuario implements Serializable {

    private ListaDE listaUsuario;
    private Usuario usuario;
    private String alInicio="1";
    private boolean deshabilitarFormulario=true;
    private NodoDE ayudante;   
    private String textoVista="Gráfico";
    
    private List listadoUsuario;
    
    private DefaultDiagramModel model;
    
    private short codigoEliminar;
            
    private short usuarioSeleccionado;
    
    private Usuario usuarioDiagrama;
    
    private int posicionUsuario;
    
    private String opcionElegida="1";
    
    private int numeroPosiciones=1;
    
    /**
     * Creates a new instance of SesionUsuario
     */
    public SesionUsuario() {
    }
        @PostConstruct
    private void inicializar()
    {       
        listaUsuario = new ListaDE();        
        //LLenado de la bds
        listaUsuario.adicionarNodo(new Usuario());
        listaUsuario.adicionarNodo(new Usuario());
        listaUsuario.adicionarNodo(new Usuario());
        ayudante = listaUsuario.getCabeza();
        usuario = ayudante.getDato();    
        //Me llena el objeto List para la tabla
        listadoUsuario = listaUsuario.obtenerListaUsuario();
        pintarLista();    
   }

    public ListaDE getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(ListaDE listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getAlInicio() {
        return alInicio;
    }

    public void setAlInicio(String alInicio) {
        this.alInicio = alInicio;
    }

    public boolean isDeshabilitarFormulario() {
        return deshabilitarFormulario;
    }

    public void setDeshabilitarFormulario(boolean deshabilitarFormulario) {
        this.deshabilitarFormulario = deshabilitarFormulario;
    }

    public String getTextoVista() {
        return textoVista;
    }

    public void setTextoVista(String textoVista) {
        this.textoVista = textoVista;
    }

    public List getListadoUsuario() {
        return listadoUsuario;
    }

    public void setListadoUsuario(List listadoUsuario) {
        this.listadoUsuario = listadoUsuario;
    }

    public short getCodigoEliminar() {
        return codigoEliminar;
    }

    public void setCodigoEliminar(short codigoEliminar) {
        this.codigoEliminar = codigoEliminar;
    }

    public short getUsuarioSeleccionado() {
        return usuarioSeleccionado;
    }

    public void setUsuarioSeleccionado(short usuarioSeleccionado) {
        this.usuarioSeleccionado = usuarioSeleccionado;
    }

    private Connection createConnection(EndPoint from, EndPoint to, String label) {
        Connection conn = new Connection(from, to);
        conn.getOverlays().add(new ArrowOverlay(20, 20, 1, 1));
         
        if(label != null) {
            conn.getOverlays().add(new LabelOverlay(label, "flow-label", 0.5));
    }
         
        return conn;
    }
        
    public Usuario getUsuarioDiagrama() {
        return usuarioDiagrama;
    }

    public void setUsuarioDiagrama(Usuario usuarioDiagrama) {
        this.usuarioDiagrama = usuarioDiagrama;
    }

    public int getPosicionUsuario() {
        return posicionUsuario;
    }

    public void setPosicionUsuario(int posicionUsuario) {
        this.posicionUsuario = posicionUsuario;
    }

    public String getOpcionElegida() {
        return opcionElegida;
    }

    public void setOpcionElegida(String opcionElegida) {
        this.opcionElegida = opcionElegida;
    }

    public int getNumeroPosiciones() {
        return numeroPosiciones;
    }
    
   public DiagramModel getModel() {
        return model;
    }

    public void setNumeroPosiciones(int numeroPosiciones) {
        this.numeroPosiciones = numeroPosiciones;
    }
   
    public void guardarUsuario()
    {
        //obtiene el consecutivo
        usuario.setIdPiloto((short)(listaUsuario.contarNodos()+1));
        if(alInicio.compareTo("1")==0)
        {
            listaUsuario.adicionarNodoAlInicio(usuario);
        }
        else
        {
            listaUsuario.adicionarNodo(usuario);
        }  
        //Vuelvo a llenar la lista para la tabla
        listadoUsuario = listaUsuario.obtenerListaUsuario();
        pintarLista();
        deshabilitarFormulario=true;
        JsfUtil.addSuccessMessage("El usuario se ha guardado exitosamente");
        
    }
    
    public void habilitarFormulario()
    {
        deshabilitarFormulario=false;
        usuario = new Usuario();
    }
    
    public void irAnterior()
    {
        if(ayudante.getAnterior()!=null)
        {
            ayudante = ayudante.getAnterior();
            usuario = ayudante.getDato();
        }        
    }
    
    
    public void irSiguiente()
    {
        if(ayudante.getSiguiente()!=null)
        {
            ayudante = ayudante.getSiguiente();
            usuario = ayudante.getDato();
        }        
    }
    
    public void irPrimero()
    {
        if(listaUsuario.getCabeza()!=null)
        {
            ayudante = listaUsuario.getCabeza();
            usuario = ayudante.getDato();
            
        }
        else
        {
            usuario = new Usuario();
        }
        listadoUsuario = listaUsuario.obtenerListaUsuario();
        pintarLista();
             
    }
    
    public void irUltimo()
    {
        if(listaUsuario.getCabeza()!=null)
        {            
            while(ayudante.getSiguiente()!=null)
            {
                ayudante = ayudante.getSiguiente();
            }
            usuario=ayudante.getDato();
        }
    }
    
    public void cambiarVistaUsuario()
    {
        if(textoVista.compareTo("Tabla")==0)
        {
            textoVista = "Gráfico";
        }
        else
        {
            textoVista = "Tabla";
        }
    }
    
//    public void invertirLista(){
//        //Invierte la lista
//        listaUsuario.invertirLista();
//        irPrimero();
//    }
    
    
    public void pintarLista() {
        //Instancia el modelo
        model = new DefaultDiagramModel();
        //Se establece para que el diagrama pueda tener infinitas flechas
        model.setMaxConnections(-1);

        StateMachineConnector connector = new StateMachineConnector();
        connector.setOrientation(StateMachineConnector.Orientation.ANTICLOCKWISE);
        connector.setPaintStyle("{strokeStyle:'#7D7463',lineWidth:3}");
        model.setDefaultConnector(connector);

        ///Adicionar los elementos
        if (listaUsuario.getCabeza() != null) {
            //llamo a mi ayudante
            NodoDE temp = listaUsuario.getCabeza();
            int posX=2;
            int posY=2;
            //recorro la lista de principio a fin
            while(temp !=null)
            {
                //Parado en un elemento
                //Crea el cuadrito y lo adiciona al modelo
                Element ele = new Element(temp.getDato().getIdPiloto()+" "+
                        temp.getDato().getNombre(), 
                        posX+"em", posY+"em");
                ele.setId(String.valueOf(temp.getDato().getIdPiloto()));
                //adiciona un conector al cuadrito
                ele.addEndPoint(new BlankEndPoint(EndPointAnchor.TOP));
                ele.addEndPoint(new BlankEndPoint(EndPointAnchor.BOTTOM_RIGHT));
                
                ele.addEndPoint(new BlankEndPoint(EndPointAnchor.BOTTOM_LEFT));
                ele.addEndPoint(new BlankEndPoint(EndPointAnchor.BOTTOM));
                model.addElement(ele);                    
                temp=temp.getSiguiente();
                posX=  posX+5;
                posY= posY+6;
            }            
           
            //Pinta las flechas            
            for(int i=0; i < model.getElements().size() -1; i++)
            {
                model.connect(createConnection(model.getElements().get(i).getEndPoints().get(1), 
                        model.getElements().get(i+1).getEndPoints().get(0), "Sig"));
                
                
                model.connect(createConnection(model.getElements().get(i+1).getEndPoints().get(2), 
                        model.getElements().get(i).getEndPoints().get(3), "Ant"));
            }
            
        }
    }
    
    public void onClickRight() {
        String id = FacesContext.getCurrentInstance().getExternalContext()
                .getRequestParameterMap().get("elementId");
         
        usuarioSeleccionado = Short.valueOf(id.replaceAll("frmInfante:diagrama-", ""));
        
    }

    public void eliminarUsuario()
    {
        if(codigoEliminar >0)
        {
            //llamo el eliminar de la lista
            try{
                listaUsuario.eliminarUsuario(codigoEliminar);
                irPrimero();
                JsfUtil.addSuccessMessage("Infante "+codigoEliminar +" eliminado.");
            }
            catch(UsuarioExcepcion e)
            {
                JsfUtil.addErrorMessage(e.getMessage());
            }
        }
        else
        {
            JsfUtil.addErrorMessage("El código a eliminar "+codigoEliminar+ " no es válido");
        }
    }
    
    
    public void obtenerDiagramaUsuario()
    {
        try {
            usuarioDiagrama = listaUsuario.obtenerUsuario(usuarioSeleccionado);
        } catch (UsuarioExcepcion ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }
       
    public void obtenerPosicionUsuario()
    {
        try {
            posicionUsuario = listaUsuario.obtenerPosicionUsuario(usuarioSeleccionado);
        } catch (UsuarioExcepcion ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }
    
    
    public void enviarAlFinal()
    {
        try {
            ///Buscar el infante y guardar los datos en una variable temporal
            Usuario infTemporal = listaUsuario.obtenerUsuario(usuarioSeleccionado);
            // Eliminar el nodo
            listaUsuario.eliminarUsuario(usuarioSeleccionado);
            // Adicionarlo al final
            listaUsuario.adicionarNodo(infTemporal);
            
            pintarLista();
        } catch (UsuarioExcepcion ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }
    
    public void enviarAlInicio()
    {
        try {
            ///Buscar el infante y guardar los datos en una variable temporal
            Usuario infTemporal = listaUsuario.obtenerUsuario(usuarioSeleccionado);
            // Eliminar el nodo
            listaUsuario.eliminarUsuario(usuarioSeleccionado);
            // Adicionarlo al inicio
            listaUsuario.adicionarNodoAlInicio(infTemporal);
            
            pintarLista();
        } catch (UsuarioExcepcion ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }
    
    public void cambiarPosicion()
    {
        boolean bandera=false;
        int posicionFinal=0;
        switch(opcionElegida)
        {
            //Ganar
            case "1":
                if(numeroPosiciones <= (posicionUsuario-1) )
                {
                    bandera=true;
                    posicionFinal = posicionUsuario - numeroPosiciones;
                }
                break;
            //Perder
            case "0":
                if(numeroPosiciones <= (listaUsuario.contarNodos()-posicionUsuario))
                {
                    bandera=true;
                    posicionFinal = posicionUsuario + numeroPosiciones;
                }
                break;
        }
        
        if(bandera)
        {
            try {
                //Realizaria la función de insertar
                Usuario datosInfante = listaUsuario.obtenerUsuario(usuarioSeleccionado);
                // cambia la cantidad de infantes
                listaUsuario.eliminarUsuario(usuarioSeleccionado);
                listaUsuario.adicionarNodoPosicion(posicionFinal, datosInfante);
                irPrimero();
                JsfUtil.addSuccessMessage("Se ha realizado el cambio");
                
                
            } catch (UsuarioExcepcion ex) {
               JsfUtil.addErrorMessage(ex.getMessage());
            }
            
        }
        else
        {
            JsfUtil.addErrorMessage("El número de posiciones no es válido para el usuario dado");
        }
    }
   
    
}

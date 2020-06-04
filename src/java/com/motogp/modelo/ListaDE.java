/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.motogp.modelo;

import com.motogp.excepciones.UsuarioExcepcion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Maria Camila
 */
public class ListaDE implements Serializable{
      private NodoDE cabeza;

    public ListaDE() {
    }

    public NodoDE getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoDE cabeza) {
        this.cabeza = cabeza;
    }
    
   public void adicionarNodo(Usuario usuario) {
        if (cabeza == null) {
            cabeza = new NodoDE(usuario);
        } else {
            //Lamo a mi ayudante
            NodoDE temp = cabeza;
            while (temp.getSiguiente() != null) //Mientras que en siguiente exista algo
            {
                temp = temp.getSiguiente();
            }
            //temp va estar ubicado en el ultimo nodo
            temp.setSiguiente(new NodoDE(usuario));
            temp.getSiguiente().setAnterior(temp);

        }
    }

    public void adicionarNodoAlInicio(Usuario usuario) {
        if (cabeza == null) {
            cabeza = new NodoDE(usuario);
        } else {
            NodoDE temp = new NodoDE(usuario);
            temp.setSiguiente(cabeza);
            cabeza.setAnterior(temp);
            cabeza = temp;
        }
    }

    /*
    Parámetros entradas  (Posición y los datos (Infante)


		- Recorrer la lista de principio a fin uno por uno contando la posición en la que estoy parado 

		- Cuando llegue a la posicion a insertar -1  

			- Creamos Nodo con la información del infante

			- Decirle al nodoinsertar que en su siguiente tome el siguiente del ayudante
			- Decirle al ayudante que en su siguiente va el niño a insertar
			- Decirle al siguiente del niño insertar que su anterior es el que estoy insertando
			- Decirle al nodoinsertar que su anterior es el ayudante
			- rompo el ciclo    
     */
    public void adicionarNodoPosicion(int posicion, Usuario dato) throws UsuarioExcepcion {
        if (cabeza != null) {
            if (posicion == 1) {
                adicionarNodoAlInicio(dato);               
            } else {
                int cont = 1;
                NodoDE temp = cabeza;
                while (temp != null) {
                    if ((posicion - 1) == cont) {
                        NodoDE nodoInsertar = new NodoDE(dato);
                        nodoInsertar.setSiguiente(temp.getSiguiente());
                        temp.setSiguiente(nodoInsertar);
                        if(nodoInsertar.getSiguiente()!=null)
                            nodoInsertar.getSiguiente().setAnterior(nodoInsertar);
                        nodoInsertar.setAnterior(temp);
                        break ;
                    }
                    temp = temp.getSiguiente();
                    cont++;
                }
            }
        }
        else{
            throw new UsuarioExcepcion(("La lista está vacía"));
        }
    }

    public short contarNodos() {
        if (cabeza == null) {
            return 0;
        } else {
            //llamar a mi ayudante
            NodoDE temp = cabeza;
            short cont = 1;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
                cont++;
            }
            return cont;
        }
    }

    public String obtenerListadoUsuario() {

        //Un método recursivo que recoora mis infantes y que sacando la
        // info la adicione een el string
        return listarUsuarios("");
    }

    public String listarUsuarios(String listado) {
        if (cabeza != null) {
            NodoDE temp = cabeza;
            while (temp != null) {
                listado += temp.getDato() + "\n";
                temp = temp.getSiguiente();

            }
            return listado;
        }
        return "No hay infantes";
    }

    public List obtenerListaUsuario() {
        List<Usuario> listado = new ArrayList<>();
        //Un método recursivo que recoora mis infantes y que sacando la
        // info la adicione een el string
        listarUsuarios(listado);
        return listado;
    }

    public void listarUsuarios(List listado) {
        if (cabeza != null) {
            NodoDE temp = cabeza;
            while (temp != null) {
                //listado += temp.getDato()+"\n";
                listado.add(temp.getDato());
                temp = temp.getSiguiente();
            }
        }

    }
    
    
// public void invertirLista() {
//        if (cabeza != null) {
//            //Crear una lista temporal la cabeza de la lista temporal está vacía
//            ListaDE listaTemporal = new ListaDE();
//            // Llamo un ayudante
//            NodoDE temp = cabeza;
//            //Recorro la lista de principio a fin
//            while (temp != null) {
//                //Parado en cada nodo , se extrae la información y se
//                // envía a la otra lista al inicio
//                listaTemporal.adicionarNodoAlInicio(temp.getDato());
//                temp = temp.getSiguiente();
//            }
//            //Igualo la cabeza de mi lista principal a la cabeza de la lista temporal
//            cabeza = listaTemporal.getCabeza();
//        }
//    }
 
 public void eliminarUsuario(short codigo) throws UsuarioExcepcion {
       if (cabeza != null) {
            if (cabeza.getDato().getIdPiloto()== codigo) {
                cabeza = cabeza.getSiguiente();
                cabeza.setAnterior(null);
                return;
            } else {
                NodoDE temp = cabeza;
                while (temp.getSiguiente() != null) {
                    if (temp.getSiguiente().getDato().getIdPiloto() == codigo) {
                        //el que sigue es el que hay que eliminar
                        temp.setSiguiente(temp.getSiguiente().getSiguiente());
                        if (temp.getSiguiente() != null) {
                            temp.getSiguiente().setAnterior(temp);
                        }
                        return;
                    }
                    temp = temp.getSiguiente();
                }

                throw new UsuarioExcepcion("El código " + codigo + " no existe en la lista");
            }
        }
        throw new UsuarioExcepcion("La lista de infantes está vacía");
    }

    public Usuario obtenerUsuario(short codigo) throws UsuarioExcepcion {
        if (cabeza != null) {
            if (cabeza.getDato().getIdPiloto() == codigo) {
                return cabeza.getDato();
            } else {
                NodoDE temp = cabeza;
                while (temp != null) {
                    if (temp.getDato().getIdPiloto() == codigo) {
                        return temp.getDato();
                    }
                    temp = temp.getSiguiente();
                }

                throw new UsuarioExcepcion("El código " + codigo + " no existe en la lista");
            }
        }
        throw new UsuarioExcepcion("La lista de usuario está vacía");
    }
    
    public int obtenerPosicionUsuario(short codigo) throws UsuarioExcepcion {
        if (cabeza != null) {
            int cont = 1;
            NodoDE temp = cabeza;
            while (temp != null) {
                if (temp.getDato().getIdPiloto() == codigo) {
                    return cont;
                }
                temp = temp.getSiguiente();
                cont++;
            }
            throw new UsuarioExcepcion("El código ingresado no ");

        }
        throw new UsuarioExcepcion("La lista de infantes está vacía");
    }

    public void adicionarNodoAlInicio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

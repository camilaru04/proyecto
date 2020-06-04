/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.motogpbs.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Maria Camila
 */
@Entity
@Table(name = "pilotos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pilotos.findAll", query = "SELECT p FROM Pilotos p")
    , @NamedQuery(name = "Pilotos.findById", query = "SELECT p FROM Pilotos p WHERE p.id = :id")
    , @NamedQuery(name = "Pilotos.findByNombre", query = "SELECT p FROM Pilotos p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Pilotos.findByIdentificacion", query = "SELECT p FROM Pilotos p WHERE p.identificacion = :identificacion")
    , @NamedQuery(name = "Pilotos.findByNacionalidad", query = "SELECT p FROM Pilotos p WHERE p.nacionalidad = :nacionalidad")
    , @NamedQuery(name = "Pilotos.findByTipoMoto", query = "SELECT p FROM Pilotos p WHERE p.tipoMoto = :tipoMoto")
    , @NamedQuery(name = "Pilotos.findByColorMoto", query = "SELECT p FROM Pilotos p WHERE p.colorMoto = :colorMoto")
    , @NamedQuery(name = "Pilotos.findByCilindraje", query = "SELECT p FROM Pilotos p WHERE p.cilindraje = :cilindraje")
    , @NamedQuery(name = "Pilotos.findByTiempoclasifiacion", query = "SELECT p FROM Pilotos p WHERE p.tiempoclasifiacion = :tiempoclasifiacion")})
public class Pilotos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Short id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "identificacion")
    private String identificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nacionalidad")
    private String nacionalidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "tipoMoto")
    private String tipoMoto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "colorMoto")
    private String colorMoto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "cilindraje")
    private String cilindraje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "tiempoclasifiacion")
    private String tiempoclasifiacion;

    public Pilotos() {
    }

    public Pilotos(Short id) {
        this.id = id;
    }

    public Pilotos(Short id, String nombre, String identificacion, String nacionalidad, String tipoMoto, String colorMoto, String cilindraje, String tiempoclasifiacion) {
        this.id = id;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.nacionalidad = nacionalidad;
        this.tipoMoto = tipoMoto;
        this.colorMoto = colorMoto;
        this.cilindraje = cilindraje;
        this.tiempoclasifiacion = tiempoclasifiacion;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getTiempoclasifiacion() {
        return tiempoclasifiacion;
    }

    public void setTiempoclasifiacion(String tiempoclasifiacion) {
        this.tiempoclasifiacion = tiempoclasifiacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pilotos)) {
            return false;
        }
        Pilotos other = (Pilotos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.motogp.controlador.Pilotos[ id=" + id + " ]";
    }
    
}

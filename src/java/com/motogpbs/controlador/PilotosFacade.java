/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.motogpbs.controlador;

import com.motogpbs.modelo.Pilotos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Maria Camila
 */
@Stateless
public class PilotosFacade extends AbstractFacade<Pilotos> {

    @PersistenceContext(unitName = "entregablesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PilotosFacade() {
        super(Pilotos.class);
    }
    
}

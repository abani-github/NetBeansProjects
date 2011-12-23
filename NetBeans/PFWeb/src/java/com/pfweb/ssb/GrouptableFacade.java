/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfweb.ssb;

import com.pfweb.entites.Grouptable;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author beheraab
 */
@Stateless
public class GrouptableFacade extends AbstractFacade<Grouptable> implements GrouptableFacadeLocal {
    @PersistenceContext(unitName = "PFWebPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public GrouptableFacade() {
        super(Grouptable.class);
    }
    
}

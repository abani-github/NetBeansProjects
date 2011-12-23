/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfweb.ssb;

import com.pfweb.entites.Usertable;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author beheraab
 */
@Stateless
public class UsertableFacade extends AbstractFacade<Usertable> implements UsertableFacadeLocal {
    @PersistenceContext(unitName = "PFWebPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public UsertableFacade() {
        super(Usertable.class);
    }
    
}

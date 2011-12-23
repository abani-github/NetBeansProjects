/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfweb.ssb;

import com.pfweb.entites.UserDetails;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author beheraab
 */
@Stateless
public class UserDetailsFacade extends AbstractFacade<UserDetails> implements UserDetailsFacadeLocal {
    @PersistenceContext(unitName = "PFWebPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public UserDetailsFacade() {
        super(UserDetails.class);
    }
    
}

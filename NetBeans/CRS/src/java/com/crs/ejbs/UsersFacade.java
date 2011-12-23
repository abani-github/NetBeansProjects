/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crs.ejbs;

import com.crs.entities.Users;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author beheraab
 */
@Stateless
public class UsersFacade extends AbstractFacade<Users> {
    @PersistenceContext(unitName = "CRSPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(Users.class);
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crs.beans;

import com.crs.ejbs.UsersFacade;
import com.crs.entities.Users;
import java.security.Principal;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author beheraab
 */
@Named(value = "userDetailsBean")
@RequestScoped
public class UserDetailsBean {
    private @EJB UsersFacade userFacede;
    private Users users;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
    /** Creates a new instance of UserDetailsBean */
    public UserDetailsBean() {
    }
    @PostConstruct
    public void populateUser(){
        String userid = getPrincipal().getName();
        System.out.println("userid " + userid);
        // 
        if ( null != userid){
           Users usr =  userFacede.find(userid);
           this.setUsers(usr);
        }
       
    }
    private HttpServletRequest getRequest() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        Object request = externalContext.getRequest();
        return request instanceof HttpServletRequest
                ? (HttpServletRequest) request : null;
    }
    public Principal getPrincipal() {
        return getRequest().getUserPrincipal();
    }
    public String change(){
        userFacede.edit(users);
        return "myhome";
    }
}

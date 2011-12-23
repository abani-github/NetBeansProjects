/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfweb.beans;

import com.pfweb.entites.UserDetails;

import com.pfweb.ssb.UserDetailsFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author beheraab
 */
@Named(value = "userDetailsBean")
@SessionScoped
public class UserDetailsBean implements Serializable {
    
    private static final Logger LOGGER = Logger.getLogger(UserDetailsBean.class.getName());
    private @EJB
    UserDetailsFacadeLocal userFacede;
    private UserDetails userDetails;
    private FacesMessage fcsMsg = null;

    public UserDetails getUserDetails() {
        return userDetails;
    }

    @PostConstruct
    public void init() {
        String user = (String) getSession().getAttribute("user");
        LOGGER.log(Level.INFO, "user from session {0}", user);
        if (null == user) {
            fcsMsg = new FacesMessage(FacesMessage.SEVERITY_WARN, "User details not found", null);
            FacesContext.getCurrentInstance().addMessage("", fcsMsg);
        } else {
            UserDetails usd = userFacede.find(user);
            System.out.println("abani er " + usd.toString());
            LOGGER.log(Level.INFO, "user details from DB {0}", usd);
            this.setUserDetails(usd);
        }
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;        
    }

    /** Creates a new instance of UserDetailsBean */
    public UserDetailsBean() {
        
    }    

    private HttpServletRequest getRequest() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        Object request = externalContext.getRequest();
        return request instanceof HttpServletRequest
                ? (HttpServletRequest) request : null;
    }

    private HttpSession getSession() {
        return getRequest().getSession();
    }

    public String change() {
        LOGGER.log(Level.INFO, "user details on update {0}", this.getUserDetails());
        userFacede.edit(this.getUserDetails());
        return "myhome";
    }
}

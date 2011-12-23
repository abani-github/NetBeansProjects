/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crs.beans;

import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author beheraab
 */
@Named(value = "loginBean")
@RequestScoped
public class LoginBean {

    private String username;
    private String password;
    private static final Logger LOGGER = Logger.getLogger(LoginBean.class.getName());
    private FacesMessage fcsMsg = null;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /** Creates a new instance of LoginBean */
    public LoginBean() {
    }

    private HttpServletRequest getRequest() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        Object request = externalContext.getRequest();
        return request instanceof HttpServletRequest
                ? (HttpServletRequest) request : null;
    }

    public boolean isAuthenticated() {
        return getRequest().getUserPrincipal() != null;
    }

    public boolean isUserInRole(String role) {
        return getRequest().isUserInRole(role);
    }

    public Principal getPrincipal() {
        return getRequest().getUserPrincipal();
    }

    public String logout() throws ServletException {
        if (isAuthenticated()) {
            getRequest().logout();
            getSession().invalidate();
        }
        return "login";
    }
    private HttpSession getSession(){
        return getRequest().getSession();
    }
    public String login() {
        String resultPage = "";
        if (!isAuthenticated()) {
            try {
                getRequest().login(username, password);
                getSession().setAttribute("user", username);
                resultPage = "myhome";
            } catch (ServletException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
                fcsMsg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Failed!!", null);
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, fcsMsg);
                this.setPassword("");
                resultPage = "login";
            }
        }else {
            resultPage = "myhome";
        }
        return resultPage;
    }
     public String change(){
         return "myhome";
     }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crs.beans;


import java.awt.event.ActionEvent;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
//import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
//import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author beheraab
 */
@Named(value = "secondController")
@RequestScoped 
public class SecondController implements Serializable {

    @ManagedProperty(value = "#{authController}")
    private AuthController authController;
    private String username;
    private static int instances = 0;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public AuthController getAuthController() {
        return authController;
    }

    public void setAuthController(AuthController authController) {
        this.authController = authController;
    }

    /** Creates a new instance of SecondController */
    public SecondController() {
        System.out.println("instances " + instances);
        instances++;
    }

    @PostConstruct
    public void init() {
        AuthController apc = FacesContext.getCurrentInstance().getApplication().evaluateExpressionGet(FacesContext.getCurrentInstance(), "#{authController}", AuthController.class);
        System.out.println("authController is " + authController);
        if (null != apc) {
            setUsername(apc.getUsername());
        }
    }

    public String callMe() {
        //System.out.println("authController is " + authController);
        return "second";
    }
    public void changeListener(ActionEvent event){
         //String encryptedName = EncDecService.encrypt(username) ;  
         System.out.println("event.getActionCommand() " );
         //this.setUsername(encryptedName);
    }
}

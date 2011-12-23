/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crs.beans;

import javax.inject.Named;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author beheraab
 */
@ManagedBean(name = "authController")
@SessionScoped
public class AuthController implements Serializable {

    /** Creates a new instance of AuthController */
    public AuthController() {
         System.out.println("instances " + instances);
        instances++;
    }
    private static int instances = 0;
    private String username;
    private boolean loggenIn;

    public boolean isLoggenIn() {
        return loggenIn;
    }

    public void setLoggenIn(boolean loggenIn) {
        this.loggenIn = loggenIn;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String authenticate (){
        return "second";
    }
}

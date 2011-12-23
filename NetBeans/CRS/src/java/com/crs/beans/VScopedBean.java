/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crs.beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author beheraab
 */
//@Named(value = "vScopedBean")
@ManagedBean(name= "vScopedBean")
//@ConversationScoped
@ViewScoped
//@Dependent
public class VScopedBean implements Serializable {
    private String userId;
    private String mobile;
    private String secans;
    private UIComponent uIComponent;

    public UIComponent getuIComponent() {
        return uIComponent;
    }

    public void setuIComponent(UIComponent uIComponent) {
        this.uIComponent = uIComponent;
    }
    
    
    public String getSecans() {
        return secans;
    }

    public void setSecans(String secans) {
        this.secans = secans;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    /** Creates a new instance of VScopedBean */
    public VScopedBean() {
        System.out.println("Creating instance");
    }
    public String onFlowProcess(FlowEvent event) {
        System.out.println("userid " + userId);
        System.out.println("mobile " + mobile);
        System.out.println("secans " + secans);
        //System.out.println("secans " + uIComponent.getClientId(context));
        return event.getNewStep();
    }
    public void printClientInfo (){
        
    }
}

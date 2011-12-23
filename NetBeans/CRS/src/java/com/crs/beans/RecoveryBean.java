/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crs.beans;

import com.crs.ejbs.UsersFacade;
import com.crs.entities.Users;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;
//import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author beheraab
 */
@ManagedBean(name = "recoveryBean")
@ViewScoped
public class RecoveryBean implements Serializable{
    
    private Users user;
    private @EJB
    UsersFacade usersFacade;

    /** Creates a new instance of RecoveryBean */
    public RecoveryBean() {
        System.out.println("creating instance");
    }
    public String userId;
    private String mobile;
    private String secans;
    private String newpass;

    public String getNewpass() {
        return newpass;
    }

    public void setNewpass(String newpass) {
        this.newpass = newpass;
    }
    private boolean passwordChanged;

    public boolean isPasswordChanged() {
        return passwordChanged;
    }

    public void setPasswordChanged(boolean passwordChanged) {
        this.passwordChanged = passwordChanged;
    }
    

    public String getSecans() {
        return secans;
    }

    public void setSecans(String secans) {
        this.secans = secans;
    }
    
    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
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

    public void save(ActionEvent event) {
    }

    public String onFlowProcess(FlowEvent event) {
        //logger.info("Current wizard step:" + event.getOldStep());  
        //logger.info("Next step:" + event.getNewStep());  
        String currentPhase = event.getOldStep();
        FacesMessage msg = null;
        if ("personal".equalsIgnoreCase(currentPhase)) {
            msg = new FacesMessage("user not found", "user not found");
            user = usersFacade.find(userId);
            this.setUser(user);
            if (null == user) {
                FacesContext.getCurrentInstance().addMessage(null, msg);
                return "personal";
            }
            return event.getNewStep();
        } 
        else if ("mobile".equalsIgnoreCase(currentPhase)) {
            System.out.println("mobie number is " + mobile);
            System.out.println("user mobile number is " + user.getMobile());
            if (!mobile.equalsIgnoreCase(user.getMobile())){
                msg = new FacesMessage("Mobile number msimatch", "Mobile number msimatch");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                return event.getOldStep();
            }
            return event.getNewStep();
        }
        else if ("secqsn".equalsIgnoreCase(currentPhase)) {
            if (!secans.equalsIgnoreCase(user.getScrans())){
                msg = new FacesMessage("In-Correct answer", "In-Correct answer");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                return event.getOldStep();
            }else {
                return event.getNewStep();
            }
        }
        else {
             return event.getNewStep();
        }
    }
    public void changePassword(){
         System.out.println("new password 1 " + this.user.getPassword());
         System.out.println("new password 2 " + this.newpass);
         setPasswordChanged(true);
         
         
    }
    private HttpServletRequest getRequest() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        Object request = externalContext.getRequest();
        return request instanceof HttpServletRequest
                ? (HttpServletRequest) request : null;
    }
    private HttpSession getSession(){
        return getRequest().getSession();
    }
}

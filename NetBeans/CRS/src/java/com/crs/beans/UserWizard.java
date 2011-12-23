/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crs.beans;

import java.awt.event.ActionEvent;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author beheraab
 */
@Named(value = "userWizard")
@RequestScoped
public class UserWizard {
    private static final Logger logger = Logger.getLogger(UserWizard.class.getName());
    /** Creates a new instance of UserWizard */
    public UserWizard() {
    }
    public void save(ActionEvent actionEvent) {
		//Persist user
		
		FacesMessage msg = new FacesMessage("Successful", "Welcome :");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public String onFlowProcess(FlowEvent event) {
		logger.info("Current wizard step:" + event.getOldStep());
		logger.info("Next step:" + event.getNewStep());
		
		
			return event.getNewStep();
		
	}
}

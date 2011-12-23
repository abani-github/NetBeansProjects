/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crs.beans;

import com.crs.ejbs.SecretQsnFacade;
import com.crs.entities.SecretQsn;
import com.crs.entities.Users;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author beheraab
 */
@Named(value = "regBean")
@RequestScoped
public class RegitsrationBean {
    private static final Logger LOGGER = Logger.getLogger(RegitsrationBean.class.getName());
    private UIComponent mybutton;
    private Users users;
    private List<SelectItem> secQsns;
    private @EJB SecretQsnFacade secrQsnEJB;
    public List<SelectItem> getSecQsns() {
        return secQsns;
    }

    public void setSecQsns(List<SelectItem> secQsns) {
        this.secQsns = secQsns;
    }
    
    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
    
    public UIComponent getMybutton() {
        return mybutton;
    }

    public void setMybutton(UIComponent mybutton) {
        this.mybutton = mybutton;
    }
    @PostConstruct
    public void init(){
       List<SecretQsn> secQ = secrQsnEJB.findAll();
       List<SelectItem> items = new ArrayList<SelectItem>(7);
       for (SecretQsn sq : secQ){
           items.add(new SelectItem(sq.getQuestions()));
       }
       setSecQsns(items);
       LOGGER.log(Level.INFO, "secQsns detail {0}", items);
    }
    //context.addMessage(mybutton.getClientId(context), message);
    /** Creates a new instance of RegitsrationBean */
    public RegitsrationBean() {
        users = new Users();
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
    public String register(){
        LOGGER.log(Level.INFO, "User detail {0}", users.getScrqsn());
        return "index";
    }
}

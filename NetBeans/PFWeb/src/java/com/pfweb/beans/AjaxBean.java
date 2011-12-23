/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfweb.beans;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author beheraab
 */
@Named(value = "ajaxBean")
@RequestScoped
public class AjaxBean {

    /** Creates a new instance of AjaxBean */
    public AjaxBean() {
        states = new ArrayList<String>(5);
        states.add("ODISHA");
        states.add("GOA");
        states.add("BIHAR");
        states.add("OTHER");
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
         System.out.println("state " + state);
        this.state = state;
    }
    private String state;
    private String dist;
    private String otherDist;
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public String getOtherDist() {
        return otherDist;
    }

    public void setOtherDist(String otherDist) {
        this.otherDist = otherDist;
    }
    
    public String getDist() {
        return dist;
    }

    public void setDist(String dist) {
        System.out.println("dist " + dist);
        this.dist = dist;
    }
    
    private List<String> states ;
    private List<String> dists ;

    public void setDists(List<String> dists) {
        this.dists = dists;
    }

    public List<String> getDists() {
        return dists;
    }

    public List<String> getStates() {
        return states;
    }

    public void setStates(List<String> states) {
        this.states = states;
    }
    public void stateChangeEvent(ValueChangeEvent e){
          String selectedState = (String)e.getNewValue();
          System.out.println("selectedState " + selectedState);
         
          setDists(DistManager.getDists(selectedState));
    }
    public void distChangeEvent(ValueChangeEvent e){
        String selectedDist = (String)e.getNewValue();
        System.out.println("selectedDist " + selectedDist);
        this.setOtherDist(selectedDist);
    }
}

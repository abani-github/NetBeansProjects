/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfweb.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.model.SelectItem;
import java.util.List;
/**
 *
 * @author beheraab
 */
@Named(value = "locationBean")
@SessionScoped
public class LocationBean implements Serializable {
     private String state, city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
     
    /** Creates a new instance of LocationBean */
    public LocationBean() {
    }
    public List<SelectItem> getStates() {
        List<SelectItem> states = new ArrayList<SelectItem>();
        states.add(new SelectItem("--- Select State ---"));
        states.add(new SelectItem("ODISHA"));
        states.add(new SelectItem("AP"));
        states.add(new SelectItem("GOA"));
        return states;
    }
    public List<SelectItem> getCities() {
        //System.out.println("Selected State is " + state);
        List<SelectItem> cities = DistManager.getCitiesByState(state);
        if (!cities.isEmpty()){
             //System.out.println("defalt city is " + cities.get(0).getValue());
            // System.out.println("defalt city  label is  " + cities.get(0).getLabel());
            this.setCity(cities.get(0).getLabel());
        }
        return cities;
    }
    public String doProcess(){
        System.out.println("state " + state);
        System.out.println("city " + city);
        return "index";
    }
    public void loadItem() {
     System.out.println("initializing data ");
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfweb.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.model.SelectItem;

/**
 *
 * @author beheraab
 */
public class DistManager {
    public static Map<String, List<String>> distMap = new HashMap<String, List<String>>();
    static {
        List<String> odisaDists = new ArrayList<String>(3);
        odisaDists.add("Ganjam");
        odisaDists.add("Rayagada");
        odisaDists.add("Katak");
        distMap.put("ODISHA", odisaDists);
        
        List<String> goaDists = new ArrayList<String>(3);
        goaDists.add("Panjim");
        goaDists.add("Margao");
        goaDists.add("Vasco");
        distMap.put("GOA", goaDists);
        
        List<String> biharDists = new ArrayList<String>(3);
        biharDists.add("Ranchi");
        biharDists.add("Raipur");
        biharDists.add("Jhansi");
        distMap.put("BIHAR", biharDists);
    }
    
    public static List<String> getDists(final String state){
        return distMap.get(state);
    }
     public static List<SelectItem> getCitiesByState(final String state){
         List<SelectItem> cities = new ArrayList<SelectItem>();
         if ("ODISHA".equalsIgnoreCase(state)) {
             cities.add(new SelectItem("BAM"));
             cities.add(new SelectItem("BBSR"));
             cities.add(new SelectItem("CTC"));
         }
         if ("AP".equalsIgnoreCase(state)) {
             cities.add(new SelectItem("VIZAG"));
             cities.add(new SelectItem("VISHAKHA"));
             cities.add(new SelectItem("VIJAYAWADA"));
         }
         if ("GOA".equalsIgnoreCase(state)) {
             cities.add(new SelectItem("MARGAO"));
             cities.add(new SelectItem("PANJIM"));
             cities.add(new SelectItem("VASCO"));
         }
         return cities;
     }
}

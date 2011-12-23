/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springjsf.services.impl;

import com.springjsf.services.CityService;
import java.util.Map;

/**
 *
 * @author beheraab
 */
public class CityServiceImpl implements CityService {

    private Map<String, Map<String, Double>> distanceMap;

    public void setDistanceMap(Map<String, Map<String, Double>> distanceMap) {
        this.distanceMap = distanceMap;
    }

    @Override
    public double findDistance(String srcCity, String destCity) {
        Map<String, Double> destinationMap = distanceMap.get(srcCity);
        
        if (destinationMap == null) {
            throw new IllegalArgumentException("Source city not found");
        }

        Double distance = destinationMap.get(destCity);

        if (distance == null) {
            throw new IllegalArgumentException("Destination city not found");
        }


        return distance;
    }
}

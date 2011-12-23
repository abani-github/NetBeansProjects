/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsfweb.cdi;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 *
 * @author beheraab
 */
public class GreeterService implements Greeter {

    @Override
    public String greet() {
        return "Hallo From " + this.getClass().getName();
    }
    
    @PostConstruct
    public void afterInitialization(){
        System.out.println("initializing");
    }
    
    @PreDestroy
    public void beforeFinalization(){
        System.out.println("finitializing");
    }
}

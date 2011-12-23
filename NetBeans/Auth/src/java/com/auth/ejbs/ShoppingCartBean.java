/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auth.ejbs;

import com.auth.interceptors.AuditInterceptor;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PreDestroy;
import javax.ejb.Stateful;
import javax.ejb.LocalBean;
import javax.ejb.Remove;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.ExcludeClassInterceptors;
import javax.interceptor.Interceptors;

/**
 *
 * @author beheraab
 */
@Stateful
@LocalBean
@TransactionAttribute(TransactionAttributeType.NEVER)
@Interceptors({AuditInterceptor.class})
public class ShoppingCartBean {

    private Map<String, Integer> cart = new HashMap<String, Integer>();

    public void buy(String product, int quantity) {
        if (cart.containsKey(product)) {
            int currq = cart.get(product);
            currq += quantity;
            cart.put(product, currq);
        } else {
            cart.put(product, quantity);
        }
    }

    @ExcludeClassInterceptors
    public void sayHelloFromAccountBean() {
        System.out.println("Invoking method: preDestroy()");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Invoking method: preDestroy()");
    }

    public Map<String, Integer> getCartContents() {
        return cart;
    }

    @Remove
    public void checkout() {
        System.out.println("To be implemented");
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auth.interceptors;

import java.io.Serializable;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;


/**
 *
 * @author beheraab
 */

public class AuditInterceptor implements Serializable {

    public AuditInterceptor() {
    }

    @AroundInvoke
    public Object audit(InvocationContext ic) throws Exception {
        System.out.println("Invoking method: " + ic.getMethod());
        return ic.proceed();
    }

    @PostActivate
    public void postActivate(InvocationContext ic) {
        System.out.println("Invoking method: " + ic.getMethod());
    }

    @PrePassivate
    public void prePassivate(InvocationContext ic) {
        System.out.println("Invoking method: " + ic.getMethod());
    }
}

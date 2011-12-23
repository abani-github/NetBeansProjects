/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listner;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Web application lifecycle listener.
 * @author beheraab
 */
@WebListener()
public class MyServletListener implements HttpSessionListener, HttpSessionAttributeListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

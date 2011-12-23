/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auth.helper;

import com.auth.ejbs.ShoppingCartBean;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;

/**
 *
 * @author beheraab
 */
public class EJBHelper {
    private static @EJB ShoppingCartBean cart;
    private static Map<String, ShoppingCartBean> ejbs = 
            new HashMap<String, ShoppingCartBean>();
    static {
       ejbs.put("shop", cart);
    }
    
     public static ShoppingCartBean getBean () {
         return ejbs.get("shop");
     }
}

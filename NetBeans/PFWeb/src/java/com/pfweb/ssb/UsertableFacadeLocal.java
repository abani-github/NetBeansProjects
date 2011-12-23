/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfweb.ssb;

import com.pfweb.entites.Usertable;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author beheraab
 */
@Local
public interface UsertableFacadeLocal {

    void create(Usertable usertable);

    void edit(Usertable usertable);

    void remove(Usertable usertable);

    Usertable find(Object id);

    List<Usertable> findAll();

    List<Usertable> findRange(int[] range);

    int count();
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfweb.ssb;

import com.pfweb.entites.Grouptable;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author beheraab
 */
@Local
public interface GrouptableFacadeLocal {

    void create(Grouptable grouptable);

    void edit(Grouptable grouptable);

    void remove(Grouptable grouptable);

    Grouptable find(Object id);

    List<Grouptable> findAll();

    List<Grouptable> findRange(int[] range);

    int count();
    
}

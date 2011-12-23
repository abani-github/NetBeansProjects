/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfweb.ssb;

import com.pfweb.entites.UserDetails;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author beheraab
 */
@Local
public interface UserDetailsFacadeLocal {

    void create(UserDetails userDetails);

    void edit(UserDetails userDetails);

    void remove(UserDetails userDetails);

    UserDetails find(Object id);

    List<UserDetails> findAll();

    List<UserDetails> findRange(int[] range);

    int count();
    
}

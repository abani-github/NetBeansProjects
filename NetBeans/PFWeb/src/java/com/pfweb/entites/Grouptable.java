/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfweb.entites;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author beheraab
 */
@Entity
@Table(name = "GROUPTABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grouptable.findAll", query = "SELECT g FROM Grouptable g"),
    @NamedQuery(name = "Grouptable.findByUserid", query = "SELECT g FROM Grouptable g WHERE g.grouptablePK.userid = :userid"),
    @NamedQuery(name = "Grouptable.findByGroupid", query = "SELECT g FROM Grouptable g WHERE g.grouptablePK.groupid = :groupid")})
public class Grouptable implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GrouptablePK grouptablePK;
    @JoinColumn(name = "USERID", referencedColumnName = "USERID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usertable usertable;

    public Grouptable() {
    }

    public Grouptable(GrouptablePK grouptablePK) {
        this.grouptablePK = grouptablePK;
    }

    public Grouptable(String userid, String groupid) {
        this.grouptablePK = new GrouptablePK(userid, groupid);
    }

    public GrouptablePK getGrouptablePK() {
        return grouptablePK;
    }

    public void setGrouptablePK(GrouptablePK grouptablePK) {
        this.grouptablePK = grouptablePK;
    }

    public Usertable getUsertable() {
        return usertable;
    }

    public void setUsertable(Usertable usertable) {
        this.usertable = usertable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grouptablePK != null ? grouptablePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grouptable)) {
            return false;
        }
        Grouptable other = (Grouptable) object;
        if ((this.grouptablePK == null && other.grouptablePK != null) || (this.grouptablePK != null && !this.grouptablePK.equals(other.grouptablePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pfweb.entites.Grouptable[ grouptablePK=" + grouptablePK + " ]";
    }
    
}

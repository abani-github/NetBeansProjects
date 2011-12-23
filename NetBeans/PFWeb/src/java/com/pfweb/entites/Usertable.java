/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfweb.entites;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author beheraab
 */
@Entity
@Table(name = "USERTABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usertable.findAll", query = "SELECT u FROM Usertable u"),
    @NamedQuery(name = "Usertable.findByUserid", query = "SELECT u FROM Usertable u WHERE u.userid = :userid"),
    @NamedQuery(name = "Usertable.findByPassword", query = "SELECT u FROM Usertable u WHERE u.password = :password")})
public class Usertable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "USERID")
    private String userid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "PASSWORD")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usertable")
    private Collection<Grouptable> grouptableCollection;

    public Usertable() {
    }

    public Usertable(String userid) {
        this.userid = userid;
    }

    public Usertable(String userid, String password) {
        this.userid = userid;
        this.password = password;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Collection<Grouptable> getGrouptableCollection() {
        return grouptableCollection;
    }

    public void setGrouptableCollection(Collection<Grouptable> grouptableCollection) {
        this.grouptableCollection = grouptableCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usertable)) {
            return false;
        }
        Usertable other = (Usertable) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pfweb.entites.Usertable[ userid=" + userid + " ]";
    }
    
}

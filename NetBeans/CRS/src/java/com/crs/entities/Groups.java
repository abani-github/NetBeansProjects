/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crs.entities;

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
@Table(name = "grouptable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Groups.findAll", query = "SELECT g FROM Groups g"),
    @NamedQuery(name = "Groups.findByUserid", query = "SELECT g FROM Groups g WHERE g.groupsPK.userid = :userid"),
    @NamedQuery(name = "Groups.findByGroupid", query = "SELECT g FROM Groups g WHERE g.groupsPK.groupid = :groupid")})
public class Groups implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GroupsPK groupsPK;
    @JoinColumn(name = "userid", referencedColumnName = "userid", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users users;

    public Groups() {
    }

    public Groups(GroupsPK groupsPK) {
        this.groupsPK = groupsPK;
    }

    public Groups(String userid, String groupid) {
        this.groupsPK = new GroupsPK(userid, groupid);
    }

    public GroupsPK getGroupsPK() {
        return groupsPK;
    }

    public void setGroupsPK(GroupsPK groupsPK) {
        this.groupsPK = groupsPK;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupsPK != null ? groupsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groups)) {
            return false;
        }
        Groups other = (Groups) object;
        if ((this.groupsPK == null && other.groupsPK != null) || (this.groupsPK != null && !this.groupsPK.equals(other.groupsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.crs.entities.Groups[ groupsPK=" + groupsPK + " ]";
    }
    
}

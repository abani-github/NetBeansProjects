/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfweb.entites;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author beheraab
 */
@Entity
@Table(name = "USER_DETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserDetails.findAll", query = "SELECT u FROM UserDetails u"),
    @NamedQuery(name = "UserDetails.findByUsername", query = "SELECT u FROM UserDetails u WHERE u.username = :username"),
    @NamedQuery(name = "UserDetails.findByFirstname", query = "SELECT u FROM UserDetails u WHERE u.firstname = :firstname"),
    @NamedQuery(name = "UserDetails.findByLastname", query = "SELECT u FROM UserDetails u WHERE u.lastname = :lastname"),
    @NamedQuery(name = "UserDetails.findByEmail", query = "SELECT u FROM UserDetails u WHERE u.email = :email"),
    @NamedQuery(name = "UserDetails.findByPhone", query = "SELECT u FROM UserDetails u WHERE u.phone = :phone")})
public class UserDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "USERNAME")
    private String username;
    @Size(max = 15)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Size(max = 15)
    @Column(name = "LASTNAME")
    private String lastname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 25)
    @Column(name = "EMAIL")
    private String email;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 11)
    @Column(name = "PHONE")
    private String phone;

    public UserDetails() {
    }

    public UserDetails(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserDetails)) {
            return false;
        }
        UserDetails other = (UserDetails) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pfweb.entites.UserDetails[ email=" + email + " ]";
    }
    
}

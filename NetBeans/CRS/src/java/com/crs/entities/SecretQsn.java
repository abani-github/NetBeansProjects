/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crs.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
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
@Table(name = "userscrqsn")
@XmlRootElement
@Cacheable
@NamedQueries({
    @NamedQuery(name = "SecretQsn.findAll", query = "SELECT s FROM SecretQsn s"),
    @NamedQuery(name = "SecretQsn.findById", query = "SELECT s FROM SecretQsn s WHERE s.id = :id"),
    @NamedQuery(name = "SecretQsn.findByQuestions", query = "SELECT s FROM SecretQsn s WHERE s.questions = :questions")})
public class SecretQsn implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id 
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "questions")
    private String questions;

    public SecretQsn() {
    }

    public SecretQsn(Integer id) {
        this.id = id;
    }

    public SecretQsn(Integer id, String questions) {
        this.id = id;
        this.questions = questions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SecretQsn)) {
            return false;
        }
        SecretQsn other = (SecretQsn) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.crs.entities.SecretQsn[ id=" + id + " ]";
    }
    
}

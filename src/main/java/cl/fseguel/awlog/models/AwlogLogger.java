/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fseguel.awlog.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fseguel
 */
@Entity
@Table(name = "awlog_logger")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AwlogLogger.findAll", query = "SELECT a FROM AwlogLogger a"),
    @NamedQuery(name = "AwlogLogger.findById", query = "SELECT a FROM AwlogLogger a WHERE a.id = :id"),
    @NamedQuery(name = "AwlogLogger.findByCreationDate", query = "SELECT a FROM AwlogLogger a WHERE a.creationDate = :creationDate"),
    @NamedQuery(name = "AwlogLogger.findByHost", query = "SELECT a FROM AwlogLogger a WHERE a.host = :host"),
    @NamedQuery(name = "AwlogLogger.findByOrigin", query = "SELECT a FROM AwlogLogger a WHERE a.origin = :origin"),
    @NamedQuery(name = "AwlogLogger.findByDetails", query = "SELECT a FROM AwlogLogger a WHERE a.details = :details"),
    @NamedQuery(name = "AwlogLogger.findByStacktrace", query = "SELECT a FROM AwlogLogger a WHERE a.stacktrace = :stacktrace")})
public class AwlogLogger implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "host")
    private String host;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "origin")
    private String origin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "details")
    private String details;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "stacktrace")
    private String stacktrace;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "logId")
    private List<AwlogLoggerHashtag> awlogLoggerHashtagList;

    public AwlogLogger() {
    }

    public AwlogLogger(BigDecimal id) {
        this.id = id;
    }

    public AwlogLogger(BigDecimal id, Date creationDate, String host, String origin, String details, String stacktrace) {
        this.id = id;
        this.creationDate = creationDate;
        this.host = host;
        this.origin = origin;
        this.details = details;
        this.stacktrace = stacktrace;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getStacktrace() {
        return stacktrace;
    }

    public void setStacktrace(String stacktrace) {
        this.stacktrace = stacktrace;
    }

    @XmlTransient
    public List<AwlogLoggerHashtag> getAwlogLoggerHashtagList() {
        return awlogLoggerHashtagList;
    }

    public void setAwlogLoggerHashtagList(List<AwlogLoggerHashtag> awlogLoggerHashtagList) {
        this.awlogLoggerHashtagList = awlogLoggerHashtagList;
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
        if (!(object instanceof AwlogLogger)) {
            return false;
        }
        AwlogLogger other = (AwlogLogger) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.fseguel.awlog.model.AwlogLogger[ id=" + id + " ]";
    }

}

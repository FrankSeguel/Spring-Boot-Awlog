/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fseguel.awlog.models;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fseguel
 */
@Entity
@Table(name = "awlog_logger_hashtag")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AwlogLoggerHashtag.findAll", query = "SELECT a FROM AwlogLoggerHashtag a"),
    @NamedQuery(name = "AwlogLoggerHashtag.findById", query = "SELECT a FROM AwlogLoggerHashtag a WHERE a.id = :id")})
public class AwlogLoggerHashtag implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private BigDecimal id;
    @JoinColumn(name = "hastag_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AwlogHashtag hastagId;
    @JoinColumn(name = "log_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AwlogLogger logId;

    public AwlogLoggerHashtag() {
    }

    public AwlogLoggerHashtag(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public AwlogHashtag getHastagId() {
        return hastagId;
    }

    public void setHastagId(AwlogHashtag hastagId) {
        this.hastagId = hastagId;
    }

    public AwlogLogger getLogId() {
        return logId;
    }

    public void setLogId(AwlogLogger logId) {
        this.logId = logId;
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
        if (!(object instanceof AwlogLoggerHashtag)) {
            return false;
        }
        AwlogLoggerHashtag other = (AwlogLoggerHashtag) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.fseguel.awlog.model.AwlogLoggerHashtag[ id=" + id + " ]";
    }

}

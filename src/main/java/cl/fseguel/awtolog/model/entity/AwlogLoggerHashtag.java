/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fseguel.awtolog.model.entity;

import cl.fseguel.awtolog.utils.reflection.BaseBean;
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
public class AwlogLoggerHashtag extends BaseBean implements Serializable {

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

}

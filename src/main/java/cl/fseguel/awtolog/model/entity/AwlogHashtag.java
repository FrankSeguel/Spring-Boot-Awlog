/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.fseguel.awtolog.model.entity;

import cl.fseguel.awtolog.utils.reflection.BaseBean;
import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fseguel
 */
@Entity
@Table(name = "awlog_hashtag")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AwlogHashtag.findAll", query = "SELECT a FROM AwlogHashtag a"),
    @NamedQuery(name = "AwlogHashtag.findById", query = "SELECT a FROM AwlogHashtag a WHERE a.id = :id"),
    @NamedQuery(name = "AwlogHashtag.findByDescription", query = "SELECT a FROM AwlogHashtag a WHERE a.description = :description")})
public class AwlogHashtag extends BaseBean implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "description")
    private String description;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hastagId")
    private List<AwlogLoggerHashtag> awlogLoggerHashtagList;

    public AwlogHashtag() {
    }

    public AwlogHashtag(Integer id) {
        this.id = id;
    }

    public AwlogHashtag(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<AwlogLoggerHashtag> getAwlogLoggerHashtagList() {
        return awlogLoggerHashtagList;
    }

    public void setAwlogLoggerHashtagList(List<AwlogLoggerHashtag> awlogLoggerHashtagList) {
        this.awlogLoggerHashtagList = awlogLoggerHashtagList;
    }

}

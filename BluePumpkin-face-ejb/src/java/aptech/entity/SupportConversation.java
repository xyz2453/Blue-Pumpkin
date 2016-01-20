/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aptech.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author NguyenDucHuy
 */
@Entity
@Table(name = "SupportConversation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupportConversation.findAll", query = "SELECT s FROM SupportConversation s"),
    @NamedQuery(name = "SupportConversation.findBySupportConversationID", query = "SELECT s FROM SupportConversation s WHERE s.supportConversationID = :supportConversationID"),
    @NamedQuery(name = "SupportConversation.findByDateCreate", query = "SELECT s FROM SupportConversation s WHERE s.dateCreate = :dateCreate"),
    @NamedQuery(name = "SupportConversation.findByContent", query = "SELECT s FROM SupportConversation s WHERE s.content = :content")})
public class SupportConversation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SupportConversationID")
    private Integer supportConversationID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateCreate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;
    @Size(max = 2147483647)
    @Column(name = "Content")
    private String content;
    @JoinColumn(name = "Username", referencedColumnName = "Username")
    @ManyToOne(optional = false)
    private Account username;
    @JoinColumn(name = "SupportID", referencedColumnName = "SupportID")
    @ManyToOne(optional = false)
    private Support supportID;

    public SupportConversation() {
    }

    public SupportConversation(Integer supportConversationID) {
        this.supportConversationID = supportConversationID;
    }

    public SupportConversation(Integer supportConversationID, Date dateCreate) {
        this.supportConversationID = supportConversationID;
        this.dateCreate = dateCreate;
    }

    public Integer getSupportConversationID() {
        return supportConversationID;
    }

    public void setSupportConversationID(Integer supportConversationID) {
        this.supportConversationID = supportConversationID;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Account getUsername() {
        return username;
    }

    public void setUsername(Account username) {
        this.username = username;
    }

    public Support getSupportID() {
        return supportID;
    }

    public void setSupportID(Support supportID) {
        this.supportID = supportID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (supportConversationID != null ? supportConversationID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SupportConversation)) {
            return false;
        }
        SupportConversation other = (SupportConversation) object;
        if ((this.supportConversationID == null && other.supportConversationID != null) || (this.supportConversationID != null && !this.supportConversationID.equals(other.supportConversationID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aptech.entity.SupportConversation[ supportConversationID=" + supportConversationID + " ]";
    }
    
}

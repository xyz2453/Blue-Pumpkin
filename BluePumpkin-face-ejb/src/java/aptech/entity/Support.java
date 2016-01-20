/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aptech.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author NguyenDucHuy
 */
@Entity
@Table(name = "Support")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Support.findAll", query = "SELECT s FROM Support s"),
    @NamedQuery(name = "Support.findBySupportID", query = "SELECT s FROM Support s WHERE s.supportID = :supportID"),
    @NamedQuery(name = "Support.findByDateCreate", query = "SELECT s FROM Support s WHERE s.dateCreate = :dateCreate"),
    @NamedQuery(name = "Support.findBySupportTitle", query = "SELECT s FROM Support s WHERE s.supportTitle = :supportTitle"),
    @NamedQuery(name = "Support.findBySupportContent", query = "SELECT s FROM Support s WHERE s.supportContent = :supportContent"),
    @NamedQuery(name = "Support.findByIsResolved", query = "SELECT s FROM Support s WHERE s.isResolved = :isResolved")})
public class Support implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SupportID")
    private Integer supportID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateCreate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "SupportTitle")
    private String supportTitle;
    @Size(max = 2147483647)
    @Column(name = "SupportContent")
    private String supportContent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isResolved")
    private boolean isResolved;
    @JoinColumn(name = "Username", referencedColumnName = "Username")
    @ManyToOne
    private Account username;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supportID")
    private List<SupportConversation> supportConversationList;

    public Support() {
    }

    public Support(Integer supportID) {
        this.supportID = supportID;
    }

    public Support(Integer supportID, Date dateCreate, String supportTitle, boolean isResolved) {
        this.supportID = supportID;
        this.dateCreate = dateCreate;
        this.supportTitle = supportTitle;
        this.isResolved = isResolved;
    }

    public Integer getSupportID() {
        return supportID;
    }

    public void setSupportID(Integer supportID) {
        this.supportID = supportID;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getSupportTitle() {
        return supportTitle;
    }

    public void setSupportTitle(String supportTitle) {
        this.supportTitle = supportTitle;
    }

    public String getSupportContent() {
        return supportContent;
    }

    public void setSupportContent(String supportContent) {
        this.supportContent = supportContent;
    }

    public boolean getIsResolved() {
        return isResolved;
    }

    public void setIsResolved(boolean isResolved) {
        this.isResolved = isResolved;
    }

    public Account getUsername() {
        return username;
    }

    public void setUsername(Account username) {
        this.username = username;
    }

    @XmlTransient
    public List<SupportConversation> getSupportConversationList() {
        return supportConversationList;
    }

    public void setSupportConversationList(List<SupportConversation> supportConversationList) {
        this.supportConversationList = supportConversationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (supportID != null ? supportID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Support)) {
            return false;
        }
        Support other = (Support) object;
        if ((this.supportID == null && other.supportID != null) || (this.supportID != null && !this.supportID.equals(other.supportID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aptech.entity.Support[ supportID=" + supportID + " ]";
    }
    
}

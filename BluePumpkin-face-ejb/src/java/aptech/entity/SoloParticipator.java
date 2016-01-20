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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author NguyenDucHuy
 */
@Entity
@Table(name = "SoloParticipator")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SoloParticipator.findAll", query = "SELECT s FROM SoloParticipator s"),
    @NamedQuery(name = "SoloParticipator.findBySoloParticipatorID", query = "SELECT s FROM SoloParticipator s WHERE s.soloParticipatorID = :soloParticipatorID"),
    @NamedQuery(name = "SoloParticipator.findByIsPending", query = "SELECT s FROM SoloParticipator s WHERE s.isPending = :isPending"),
    @NamedQuery(name = "SoloParticipator.findByRegDate", query = "SELECT s FROM SoloParticipator s WHERE s.regDate = :regDate")})
public class SoloParticipator implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SoloParticipatorID")
    private Integer soloParticipatorID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isPending")
    private boolean isPending;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RegDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regDate;
    @JoinColumn(name = "Username", referencedColumnName = "Username")
    @ManyToOne(optional = false)
    private Account username;
    @JoinColumn(name = "EventID", referencedColumnName = "EventID")
    @ManyToOne(optional = false)
    private Event eventID;

    public SoloParticipator() {
    }

    public SoloParticipator(Integer soloParticipatorID) {
        this.soloParticipatorID = soloParticipatorID;
    }

    public SoloParticipator(Integer soloParticipatorID, boolean isPending, Date regDate) {
        this.soloParticipatorID = soloParticipatorID;
        this.isPending = isPending;
        this.regDate = regDate;
    }

    public Integer getSoloParticipatorID() {
        return soloParticipatorID;
    }

    public void setSoloParticipatorID(Integer soloParticipatorID) {
        this.soloParticipatorID = soloParticipatorID;
    }

    public boolean getIsPending() {
        return isPending;
    }

    public void setIsPending(boolean isPending) {
        this.isPending = isPending;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Account getUsername() {
        return username;
    }

    public void setUsername(Account username) {
        this.username = username;
    }

    public Event getEventID() {
        return eventID;
    }

    public void setEventID(Event eventID) {
        this.eventID = eventID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (soloParticipatorID != null ? soloParticipatorID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SoloParticipator)) {
            return false;
        }
        SoloParticipator other = (SoloParticipator) object;
        if ((this.soloParticipatorID == null && other.soloParticipatorID != null) || (this.soloParticipatorID != null && !this.soloParticipatorID.equals(other.soloParticipatorID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aptech.entity.SoloParticipator[ soloParticipatorID=" + soloParticipatorID + " ]";
    }
    
}

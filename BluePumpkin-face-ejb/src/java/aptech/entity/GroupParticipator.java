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
@Table(name = "GroupParticipator")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GroupParticipator.findAll", query = "SELECT g FROM GroupParticipator g"),
    @NamedQuery(name = "GroupParticipator.findByGroupParticipatorID", query = "SELECT g FROM GroupParticipator g WHERE g.groupParticipatorID = :groupParticipatorID"),
    @NamedQuery(name = "GroupParticipator.findByIsPending", query = "SELECT g FROM GroupParticipator g WHERE g.isPending = :isPending"),
    @NamedQuery(name = "GroupParticipator.findByRegDate", query = "SELECT g FROM GroupParticipator g WHERE g.regDate = :regDate")})
public class GroupParticipator implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "GroupParticipatorID")
    private Integer groupParticipatorID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isPending")
    private boolean isPending;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RegDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regDate;
    @JoinColumn(name = "EventID", referencedColumnName = "EventID")
    @ManyToOne(optional = false)
    private Event eventID;
    @JoinColumn(name = "GroupID", referencedColumnName = "GroupID")
    @ManyToOne(optional = false)
    private EventGroup groupID;

    public GroupParticipator() {
    }

    public GroupParticipator(Integer groupParticipatorID) {
        this.groupParticipatorID = groupParticipatorID;
    }

    public GroupParticipator(Integer groupParticipatorID, boolean isPending, Date regDate) {
        this.groupParticipatorID = groupParticipatorID;
        this.isPending = isPending;
        this.regDate = regDate;
    }

    public Integer getGroupParticipatorID() {
        return groupParticipatorID;
    }

    public void setGroupParticipatorID(Integer groupParticipatorID) {
        this.groupParticipatorID = groupParticipatorID;
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

    public Event getEventID() {
        return eventID;
    }

    public void setEventID(Event eventID) {
        this.eventID = eventID;
    }

    public EventGroup getGroupID() {
        return groupID;
    }

    public void setGroupID(EventGroup groupID) {
        this.groupID = groupID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupParticipatorID != null ? groupParticipatorID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GroupParticipator)) {
            return false;
        }
        GroupParticipator other = (GroupParticipator) object;
        if ((this.groupParticipatorID == null && other.groupParticipatorID != null) || (this.groupParticipatorID != null && !this.groupParticipatorID.equals(other.groupParticipatorID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aptech.entity.GroupParticipator[ groupParticipatorID=" + groupParticipatorID + " ]";
    }
    
}

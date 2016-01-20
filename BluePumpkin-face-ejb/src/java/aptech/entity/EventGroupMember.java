/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aptech.entity;

import java.io.Serializable;
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
 * @author NguyenDucHuy
 */
@Entity
@Table(name = "EventGroupMember")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EventGroupMember.findAll", query = "SELECT e FROM EventGroupMember e"),
    @NamedQuery(name = "EventGroupMember.findByEventGroupMemberID", query = "SELECT e FROM EventGroupMember e WHERE e.eventGroupMemberID = :eventGroupMemberID"),
    @NamedQuery(name = "EventGroupMember.findByIsLeader", query = "SELECT e FROM EventGroupMember e WHERE e.isLeader = :isLeader"),
    @NamedQuery(name = "EventGroupMember.findByIsPending", query = "SELECT e FROM EventGroupMember e WHERE e.isPending = :isPending")})
public class EventGroupMember implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EventGroupMemberID")
    private Integer eventGroupMemberID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isLeader")
    private boolean isLeader;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isPending")
    private boolean isPending;
    @JoinColumn(name = "Username", referencedColumnName = "Username")
    @ManyToOne(optional = false)
    private Account username;
    @JoinColumn(name = "GroupID", referencedColumnName = "GroupID")
    @ManyToOne(optional = false)
    private EventGroup groupID;

    public EventGroupMember() {
    }

    public EventGroupMember(Integer eventGroupMemberID) {
        this.eventGroupMemberID = eventGroupMemberID;
    }

    public EventGroupMember(Integer eventGroupMemberID, boolean isLeader, boolean isPending) {
        this.eventGroupMemberID = eventGroupMemberID;
        this.isLeader = isLeader;
        this.isPending = isPending;
    }

    public Integer getEventGroupMemberID() {
        return eventGroupMemberID;
    }

    public void setEventGroupMemberID(Integer eventGroupMemberID) {
        this.eventGroupMemberID = eventGroupMemberID;
    }

    public boolean getIsLeader() {
        return isLeader;
    }

    public void setIsLeader(boolean isLeader) {
        this.isLeader = isLeader;
    }

    public boolean getIsPending() {
        return isPending;
    }

    public void setIsPending(boolean isPending) {
        this.isPending = isPending;
    }

    public Account getUsername() {
        return username;
    }

    public void setUsername(Account username) {
        this.username = username;
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
        hash += (eventGroupMemberID != null ? eventGroupMemberID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventGroupMember)) {
            return false;
        }
        EventGroupMember other = (EventGroupMember) object;
        if ((this.eventGroupMemberID == null && other.eventGroupMemberID != null) || (this.eventGroupMemberID != null && !this.eventGroupMemberID.equals(other.eventGroupMemberID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aptech.entity.EventGroupMember[ eventGroupMemberID=" + eventGroupMemberID + " ]";
    }
    
}

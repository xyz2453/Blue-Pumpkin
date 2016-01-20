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
@Table(name = "EventGroup")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EventGroup.findAll", query = "SELECT e FROM EventGroup e"),
    @NamedQuery(name = "EventGroup.findByGroupID", query = "SELECT e FROM EventGroup e WHERE e.groupID = :groupID"),
    @NamedQuery(name = "EventGroup.findByGroupName", query = "SELECT e FROM EventGroup e WHERE e.groupName = :groupName"),
    @NamedQuery(name = "EventGroup.findByGroupDescription", query = "SELECT e FROM EventGroup e WHERE e.groupDescription = :groupDescription"),
    @NamedQuery(name = "EventGroup.findByDateCreate", query = "SELECT e FROM EventGroup e WHERE e.dateCreate = :dateCreate")})
public class EventGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "GroupID")
    private Integer groupID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "GroupName")
    private String groupName;
    @Size(max = 100)
    @Column(name = "GroupDescription")
    private String groupDescription;
    @Column(name = "DateCreate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupID")
    private List<EventGroupMember> eventGroupMemberList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupID")
    private List<GroupParticipator> groupParticipatorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupID")
    private List<GroupWinner> groupWinnerList;

    public EventGroup() {
    }

    public EventGroup(Integer groupID) {
        this.groupID = groupID;
    }

    public EventGroup(Integer groupID, String groupName) {
        this.groupID = groupID;
        this.groupName = groupName;
    }

    public Integer getGroupID() {
        return groupID;
    }

    public void setGroupID(Integer groupID) {
        this.groupID = groupID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    @XmlTransient
    public List<EventGroupMember> getEventGroupMemberList() {
        return eventGroupMemberList;
    }

    public void setEventGroupMemberList(List<EventGroupMember> eventGroupMemberList) {
        this.eventGroupMemberList = eventGroupMemberList;
    }

    @XmlTransient
    public List<GroupParticipator> getGroupParticipatorList() {
        return groupParticipatorList;
    }

    public void setGroupParticipatorList(List<GroupParticipator> groupParticipatorList) {
        this.groupParticipatorList = groupParticipatorList;
    }

    @XmlTransient
    public List<GroupWinner> getGroupWinnerList() {
        return groupWinnerList;
    }

    public void setGroupWinnerList(List<GroupWinner> groupWinnerList) {
        this.groupWinnerList = groupWinnerList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupID != null ? groupID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventGroup)) {
            return false;
        }
        EventGroup other = (EventGroup) object;
        if ((this.groupID == null && other.groupID != null) || (this.groupID != null && !this.groupID.equals(other.groupID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aptech.entity.EventGroup[ groupID=" + groupID + " ]";
    }
    
}

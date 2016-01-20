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
@Table(name = "Event")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e"),
    @NamedQuery(name = "Event.findByEventID", query = "SELECT e FROM Event e WHERE e.eventID = :eventID"),
    @NamedQuery(name = "Event.findByDateCreate", query = "SELECT e FROM Event e WHERE e.dateCreate = :dateCreate"),
    @NamedQuery(name = "Event.findByEventTitle", query = "SELECT e FROM Event e WHERE e.eventTitle = :eventTitle"),
    @NamedQuery(name = "Event.findByEventContent", query = "SELECT e FROM Event e WHERE e.eventContent = :eventContent"),
    @NamedQuery(name = "Event.findByEventThumbnail", query = "SELECT e FROM Event e WHERE e.eventThumbnail = :eventThumbnail")})
public class Event implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EventID")
    private Integer eventID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateCreate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "EventTitle")
    private String eventTitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "EventContent")
    private String eventContent;
    @Size(max = 2147483647)
    @Column(name = "EventThumbnail")
    private String eventThumbnail;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventID")
    private List<SoloWinner> soloWinnerList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventID")
    private List<GroupParticipator> groupParticipatorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventID")
    private List<Prize> prizeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventID")
    private List<SoloParticipator> soloParticipatorList;
    @JoinColumn(name = "Username", referencedColumnName = "Username")
    @ManyToOne(optional = false)
    private Account username;
    @JoinColumn(name = "EventTypeID", referencedColumnName = "EventTypeID")
    @ManyToOne(optional = false)
    private EventType eventTypeID;
    @JoinColumn(name = "RequirementID", referencedColumnName = "RequirementID")
    @ManyToOne(optional = false)
    private Requirement requirementID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventID")
    private List<GroupWinner> groupWinnerList;

    public Event() {
    }

    public Event(Integer eventID) {
        this.eventID = eventID;
    }

    public Event(Integer eventID, Date dateCreate, String eventTitle, String eventContent) {
        this.eventID = eventID;
        this.dateCreate = dateCreate;
        this.eventTitle = eventTitle;
        this.eventContent = eventContent;
    }

    public Integer getEventID() {
        return eventID;
    }

    public void setEventID(Integer eventID) {
        this.eventID = eventID;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventContent() {
        return eventContent;
    }

    public void setEventContent(String eventContent) {
        this.eventContent = eventContent;
    }

    public String getEventThumbnail() {
        return eventThumbnail;
    }

    public void setEventThumbnail(String eventThumbnail) {
        this.eventThumbnail = eventThumbnail;
    }

    @XmlTransient
    public List<SoloWinner> getSoloWinnerList() {
        return soloWinnerList;
    }

    public void setSoloWinnerList(List<SoloWinner> soloWinnerList) {
        this.soloWinnerList = soloWinnerList;
    }

    @XmlTransient
    public List<GroupParticipator> getGroupParticipatorList() {
        return groupParticipatorList;
    }

    public void setGroupParticipatorList(List<GroupParticipator> groupParticipatorList) {
        this.groupParticipatorList = groupParticipatorList;
    }

    @XmlTransient
    public List<Prize> getPrizeList() {
        return prizeList;
    }

    public void setPrizeList(List<Prize> prizeList) {
        this.prizeList = prizeList;
    }

    @XmlTransient
    public List<SoloParticipator> getSoloParticipatorList() {
        return soloParticipatorList;
    }

    public void setSoloParticipatorList(List<SoloParticipator> soloParticipatorList) {
        this.soloParticipatorList = soloParticipatorList;
    }

    public Account getUsername() {
        return username;
    }

    public void setUsername(Account username) {
        this.username = username;
    }

    public EventType getEventTypeID() {
        return eventTypeID;
    }

    public void setEventTypeID(EventType eventTypeID) {
        this.eventTypeID = eventTypeID;
    }

    public Requirement getRequirementID() {
        return requirementID;
    }

    public void setRequirementID(Requirement requirementID) {
        this.requirementID = requirementID;
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
        hash += (eventID != null ? eventID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.eventID == null && other.eventID != null) || (this.eventID != null && !this.eventID.equals(other.eventID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aptech.entity.Event[ eventID=" + eventID + " ]";
    }
    
}

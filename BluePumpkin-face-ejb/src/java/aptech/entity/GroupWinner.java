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
@Table(name = "GroupWinner")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GroupWinner.findAll", query = "SELECT g FROM GroupWinner g"),
    @NamedQuery(name = "GroupWinner.findByGroupWinnerID", query = "SELECT g FROM GroupWinner g WHERE g.groupWinnerID = :groupWinnerID")})
public class GroupWinner implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "GroupWinnerID")
    private Integer groupWinnerID;
    @JoinColumn(name = "EventID", referencedColumnName = "EventID")
    @ManyToOne(optional = false)
    private Event eventID;
    @JoinColumn(name = "GroupID", referencedColumnName = "GroupID")
    @ManyToOne(optional = false)
    private EventGroup groupID;
    @JoinColumn(name = "PrizeID", referencedColumnName = "PrizeID")
    @ManyToOne(optional = false)
    private Prize prizeID;

    public GroupWinner() {
    }

    public GroupWinner(Integer groupWinnerID) {
        this.groupWinnerID = groupWinnerID;
    }

    public Integer getGroupWinnerID() {
        return groupWinnerID;
    }

    public void setGroupWinnerID(Integer groupWinnerID) {
        this.groupWinnerID = groupWinnerID;
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

    public Prize getPrizeID() {
        return prizeID;
    }

    public void setPrizeID(Prize prizeID) {
        this.prizeID = prizeID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupWinnerID != null ? groupWinnerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GroupWinner)) {
            return false;
        }
        GroupWinner other = (GroupWinner) object;
        if ((this.groupWinnerID == null && other.groupWinnerID != null) || (this.groupWinnerID != null && !this.groupWinnerID.equals(other.groupWinnerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aptech.entity.GroupWinner[ groupWinnerID=" + groupWinnerID + " ]";
    }
    
}

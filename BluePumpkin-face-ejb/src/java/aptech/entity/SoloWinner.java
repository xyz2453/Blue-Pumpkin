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
@Table(name = "SoloWinner")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SoloWinner.findAll", query = "SELECT s FROM SoloWinner s"),
    @NamedQuery(name = "SoloWinner.findBySoloWinnerID", query = "SELECT s FROM SoloWinner s WHERE s.soloWinnerID = :soloWinnerID")})
public class SoloWinner implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SoloWinnerID")
    private Integer soloWinnerID;
    @JoinColumn(name = "Username", referencedColumnName = "Username")
    @ManyToOne(optional = false)
    private Account username;
    @JoinColumn(name = "EventID", referencedColumnName = "EventID")
    @ManyToOne(optional = false)
    private Event eventID;
    @JoinColumn(name = "PrizeID", referencedColumnName = "PrizeID")
    @ManyToOne(optional = false)
    private Prize prizeID;

    public SoloWinner() {
    }

    public SoloWinner(Integer soloWinnerID) {
        this.soloWinnerID = soloWinnerID;
    }

    public Integer getSoloWinnerID() {
        return soloWinnerID;
    }

    public void setSoloWinnerID(Integer soloWinnerID) {
        this.soloWinnerID = soloWinnerID;
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

    public Prize getPrizeID() {
        return prizeID;
    }

    public void setPrizeID(Prize prizeID) {
        this.prizeID = prizeID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (soloWinnerID != null ? soloWinnerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SoloWinner)) {
            return false;
        }
        SoloWinner other = (SoloWinner) object;
        if ((this.soloWinnerID == null && other.soloWinnerID != null) || (this.soloWinnerID != null && !this.soloWinnerID.equals(other.soloWinnerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aptech.entity.SoloWinner[ soloWinnerID=" + soloWinnerID + " ]";
    }
    
}

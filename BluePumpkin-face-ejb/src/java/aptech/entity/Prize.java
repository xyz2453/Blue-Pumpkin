/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aptech.entity;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author NguyenDucHuy
 */
@Entity
@Table(name = "Prize")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prize.findAll", query = "SELECT p FROM Prize p"),
    @NamedQuery(name = "Prize.findByPrizeID", query = "SELECT p FROM Prize p WHERE p.prizeID = :prizeID"),
    @NamedQuery(name = "Prize.findByPrizeOrder", query = "SELECT p FROM Prize p WHERE p.prizeOrder = :prizeOrder"),
    @NamedQuery(name = "Prize.findByPrizeContent", query = "SELECT p FROM Prize p WHERE p.prizeContent = :prizeContent")})
public class Prize implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PrizeID")
    private Integer prizeID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PrizeOrder")
    private int prizeOrder;
    @Size(max = 2147483647)
    @Column(name = "PrizeContent")
    private String prizeContent;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prizeID")
    private List<SoloWinner> soloWinnerList;
    @JoinColumn(name = "EventID", referencedColumnName = "EventID")
    @ManyToOne(optional = false)
    private Event eventID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prizeID")
    private List<GroupWinner> groupWinnerList;

    public Prize() {
    }

    public Prize(Integer prizeID) {
        this.prizeID = prizeID;
    }

    public Prize(Integer prizeID, int prizeOrder) {
        this.prizeID = prizeID;
        this.prizeOrder = prizeOrder;
    }

    public Integer getPrizeID() {
        return prizeID;
    }

    public void setPrizeID(Integer prizeID) {
        this.prizeID = prizeID;
    }

    public int getPrizeOrder() {
        return prizeOrder;
    }

    public void setPrizeOrder(int prizeOrder) {
        this.prizeOrder = prizeOrder;
    }

    public String getPrizeContent() {
        return prizeContent;
    }

    public void setPrizeContent(String prizeContent) {
        this.prizeContent = prizeContent;
    }

    @XmlTransient
    public List<SoloWinner> getSoloWinnerList() {
        return soloWinnerList;
    }

    public void setSoloWinnerList(List<SoloWinner> soloWinnerList) {
        this.soloWinnerList = soloWinnerList;
    }

    public Event getEventID() {
        return eventID;
    }

    public void setEventID(Event eventID) {
        this.eventID = eventID;
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
        hash += (prizeID != null ? prizeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prize)) {
            return false;
        }
        Prize other = (Prize) object;
        if ((this.prizeID == null && other.prizeID != null) || (this.prizeID != null && !this.prizeID.equals(other.prizeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aptech.entity.Prize[ prizeID=" + prizeID + " ]";
    }
    
}

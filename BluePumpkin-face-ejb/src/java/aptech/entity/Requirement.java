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
@Table(name = "Requirement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Requirement.findAll", query = "SELECT r FROM Requirement r"),
    @NamedQuery(name = "Requirement.findByRequirementID", query = "SELECT r FROM Requirement r WHERE r.requirementID = :requirementID"),
    @NamedQuery(name = "Requirement.findByMaxParticipator", query = "SELECT r FROM Requirement r WHERE r.maxParticipator = :maxParticipator"),
    @NamedQuery(name = "Requirement.findByRegStartDate", query = "SELECT r FROM Requirement r WHERE r.regStartDate = :regStartDate"),
    @NamedQuery(name = "Requirement.findByRegEndDate", query = "SELECT r FROM Requirement r WHERE r.regEndDate = :regEndDate"),
    @NamedQuery(name = "Requirement.findByEventStartDate", query = "SELECT r FROM Requirement r WHERE r.eventStartDate = :eventStartDate"),
    @NamedQuery(name = "Requirement.findByGender", query = "SELECT r FROM Requirement r WHERE r.gender = :gender"),
    @NamedQuery(name = "Requirement.findByExtraNote", query = "SELECT r FROM Requirement r WHERE r.extraNote = :extraNote"),
    @NamedQuery(name = "Requirement.findByIsGroup", query = "SELECT r FROM Requirement r WHERE r.isGroup = :isGroup"),
    @NamedQuery(name = "Requirement.findByMaxMemberPerGroup", query = "SELECT r FROM Requirement r WHERE r.maxMemberPerGroup = :maxMemberPerGroup")})
public class Requirement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RequirementID")
    private Integer requirementID;
    @Column(name = "MaxParticipator")
    private Integer maxParticipator;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RegStartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regStartDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RegEndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regEndDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EventStartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eventStartDate;
    @Column(name = "Gender")
    private Boolean gender;
    @Size(max = 2147483647)
    @Column(name = "ExtraNote")
    private String extraNote;
    @Column(name = "isGroup")
    private Boolean isGroup;
    @Column(name = "MaxMemberPerGroup")
    private Integer maxMemberPerGroup;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requirementID")
    private List<Event> eventList;

    public Requirement() {
    }

    public Requirement(Integer requirementID) {
        this.requirementID = requirementID;
    }

    public Requirement(Integer requirementID, Date regStartDate, Date regEndDate, Date eventStartDate) {
        this.requirementID = requirementID;
        this.regStartDate = regStartDate;
        this.regEndDate = regEndDate;
        this.eventStartDate = eventStartDate;
    }

    public Integer getRequirementID() {
        return requirementID;
    }

    public void setRequirementID(Integer requirementID) {
        this.requirementID = requirementID;
    }

    public Integer getMaxParticipator() {
        return maxParticipator;
    }

    public void setMaxParticipator(Integer maxParticipator) {
        this.maxParticipator = maxParticipator;
    }

    public Date getRegStartDate() {
        return regStartDate;
    }

    public void setRegStartDate(Date regStartDate) {
        this.regStartDate = regStartDate;
    }

    public Date getRegEndDate() {
        return regEndDate;
    }

    public void setRegEndDate(Date regEndDate) {
        this.regEndDate = regEndDate;
    }

    public Date getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(Date eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getExtraNote() {
        return extraNote;
    }

    public void setExtraNote(String extraNote) {
        this.extraNote = extraNote;
    }

    public Boolean getIsGroup() {
        return isGroup;
    }

    public void setIsGroup(Boolean isGroup) {
        this.isGroup = isGroup;
    }

    public Integer getMaxMemberPerGroup() {
        return maxMemberPerGroup;
    }

    public void setMaxMemberPerGroup(Integer maxMemberPerGroup) {
        this.maxMemberPerGroup = maxMemberPerGroup;
    }

    @XmlTransient
    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requirementID != null ? requirementID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requirement)) {
            return false;
        }
        Requirement other = (Requirement) object;
        if ((this.requirementID == null && other.requirementID != null) || (this.requirementID != null && !this.requirementID.equals(other.requirementID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aptech.entity.Requirement[ requirementID=" + requirementID + " ]";
    }
    
}

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author NguyenDucHuy
 */
@Entity
@Table(name = "AboutAndContract")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AboutAndContract.findAll", query = "SELECT a FROM AboutAndContract a"),
    @NamedQuery(name = "AboutAndContract.findByAboutAndContractID", query = "SELECT a FROM AboutAndContract a WHERE a.aboutAndContractID = :aboutAndContractID"),
    @NamedQuery(name = "AboutAndContract.findByAbout", query = "SELECT a FROM AboutAndContract a WHERE a.about = :about"),
    @NamedQuery(name = "AboutAndContract.findByContract", query = "SELECT a FROM AboutAndContract a WHERE a.contract = :contract")})
public class AboutAndContract implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "AboutAndContractID")
    private Integer aboutAndContractID;
    @Size(max = 2147483647)
    @Column(name = "About")
    private String about;
    @Size(max = 2147483647)
    @Column(name = "Contract")
    private String contract;

    public AboutAndContract() {
    }

    public AboutAndContract(Integer aboutAndContractID) {
        this.aboutAndContractID = aboutAndContractID;
    }

    public Integer getAboutAndContractID() {
        return aboutAndContractID;
    }

    public void setAboutAndContractID(Integer aboutAndContractID) {
        this.aboutAndContractID = aboutAndContractID;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aboutAndContractID != null ? aboutAndContractID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AboutAndContract)) {
            return false;
        }
        AboutAndContract other = (AboutAndContract) object;
        if ((this.aboutAndContractID == null && other.aboutAndContractID != null) || (this.aboutAndContractID != null && !this.aboutAndContractID.equals(other.aboutAndContractID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aptech.entity.AboutAndContract[ aboutAndContractID=" + aboutAndContractID + " ]";
    }
    
}

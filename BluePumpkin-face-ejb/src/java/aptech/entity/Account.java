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
@Table(name = "Account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
    @NamedQuery(name = "Account.findByUsername", query = "SELECT a FROM Account a WHERE a.username = :username"),
    @NamedQuery(name = "Account.findByPassword", query = "SELECT a FROM Account a WHERE a.password = :password"),
    @NamedQuery(name = "Account.findByRole", query = "SELECT a FROM Account a WHERE a.role = :role"),
    @NamedQuery(name = "Account.findByFullname", query = "SELECT a FROM Account a WHERE a.fullname = :fullname"),
    @NamedQuery(name = "Account.findByBirthday", query = "SELECT a FROM Account a WHERE a.birthday = :birthday"),
    @NamedQuery(name = "Account.findByAddress", query = "SELECT a FROM Account a WHERE a.address = :address"),
    @NamedQuery(name = "Account.findByEmail", query = "SELECT a FROM Account a WHERE a.email = :email"),
    @NamedQuery(name = "Account.findByPhone", query = "SELECT a FROM Account a WHERE a.phone = :phone"),
    @NamedQuery(name = "Account.findByIsBlocked", query = "SELECT a FROM Account a WHERE a.isBlocked = :isBlocked"),
    @NamedQuery(name = "Account.findByGender", query = "SELECT a FROM Account a WHERE a.gender = :gender")})
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Role")
    private boolean role;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Fullname")
    private String fullname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Birthday")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;
    @Size(max = 100)
    @Column(name = "Address")
    private String address;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 60)
    @Column(name = "Email")
    private String email;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 13)
    @Column(name = "Phone")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isBlocked")
    private boolean isBlocked;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Gender")
    private boolean gender;
    @JoinColumn(name = "DepartmentID", referencedColumnName = "DepartmentID")
    @ManyToOne(optional = false)
    private Department departmentID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "username")
    private List<SoloWinner> soloWinnerList;
    @OneToMany(mappedBy = "username")
    private List<Support> supportList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "username")
    private List<EventGroupMember> eventGroupMemberList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "username")
    private List<SupportConversation> supportConversationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "username")
    private List<SoloParticipator> soloParticipatorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "username")
    private List<News> newsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "username")
    private List<Event> eventList;

    public Account() {
    }

    public Account(String username) {
        this.username = username;
    }

    public Account(String username, String password, boolean role, String fullname, Date birthday, boolean isBlocked, boolean gender) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.fullname = fullname;
        this.birthday = birthday;
        this.isBlocked = isBlocked;
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(boolean isBlocked) {
        this.isBlocked = isBlocked;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Department getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Department departmentID) {
        this.departmentID = departmentID;
    }

    @XmlTransient
    public List<SoloWinner> getSoloWinnerList() {
        return soloWinnerList;
    }

    public void setSoloWinnerList(List<SoloWinner> soloWinnerList) {
        this.soloWinnerList = soloWinnerList;
    }

    @XmlTransient
    public List<Support> getSupportList() {
        return supportList;
    }

    public void setSupportList(List<Support> supportList) {
        this.supportList = supportList;
    }

    @XmlTransient
    public List<EventGroupMember> getEventGroupMemberList() {
        return eventGroupMemberList;
    }

    public void setEventGroupMemberList(List<EventGroupMember> eventGroupMemberList) {
        this.eventGroupMemberList = eventGroupMemberList;
    }

    @XmlTransient
    public List<SupportConversation> getSupportConversationList() {
        return supportConversationList;
    }

    public void setSupportConversationList(List<SupportConversation> supportConversationList) {
        this.supportConversationList = supportConversationList;
    }

    @XmlTransient
    public List<SoloParticipator> getSoloParticipatorList() {
        return soloParticipatorList;
    }

    public void setSoloParticipatorList(List<SoloParticipator> soloParticipatorList) {
        this.soloParticipatorList = soloParticipatorList;
    }

    @XmlTransient
    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
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
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aptech.entity.Account[ username=" + username + " ]";
    }
    
}

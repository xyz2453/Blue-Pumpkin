/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aptech.mb;

import aptech.entity.Account;
import aptech.entity.Department;
import aptech.sb.AccountFacadeLocal;
import aptech.sb.DepartmentFacadeLocal;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author NguyenDucHuy
 */
@ManagedBean
@ViewScoped
public class EmpPanelMb {
    @EJB
    private AccountFacadeLocal accountFacade;
    @EJB
    private DepartmentFacadeLocal departmentFacade;
    @ManagedProperty(value="#{loginMb}")
    private LoginMb loginMb;
    
    private String message;
    
    private Account updateAccount;
    private String updateDepartmentID;
    
    private List<Account> searchResult;

    public class SearchInput {
        public String username;
        public String searchDepartmentID;
        public Boolean gender;
        public Boolean isadmin;
        public String fullname;
        public Date birthday;
        public String address;
        public String email;
        public String phone;

        public SearchInput() {
        }
        /**
         * @return the username
         */
        public String getUsername() {
            return username;
        }

        /**
         * @param username the username to set
         */
        public void setUsername(String username) {
            this.username = username;
        }

        /**
         * @return the searchDepartmentID
         */
        public String getSearchDepartmentID() {
            return searchDepartmentID;
        }

        /**
         * @param searchDepartmentID the searchDepartmentID to set
         */
        public void setSearchDepartmentID(String searchDepartmentID) {
            this.searchDepartmentID = searchDepartmentID;
        }

        /**
         * @return the gender
         */
        public Boolean getGender() {
            return gender;
        }

        /**
         * @param gender the gender to set
         */
        public void setGender(Boolean gender) {
            this.gender = gender;
        }

        /**
         * @return the isadmin
         */
        public Boolean getIsadmin() {
            return isadmin;
        }

        /**
         * @param isadmin the isadmin to set
         */
        public void setIsadmin(Boolean isadmin) {
            this.isadmin = isadmin;
        }

        /**
         * @return the fullname
         */
        public String getFullname() {
            return fullname;
        }

        /**
         * @param fullname the fullname to set
         */
        public void setFullname(String fullname) {
            this.fullname = fullname;
        }

        /**
         * @return the birthday
         */
        public Date getBirthday() {
            return birthday;
        }

        /**
         * @param birthday the birthday to set
         */
        public void setBirthday(Date birthday) {
            this.birthday = birthday;
        }

        /**
         * @return the address
         */
        public String getAddress() {
            return address;
        }

        /**
         * @param address the address to set
         */
        public void setAddress(String address) {
            this.address = address;
        }

        /**
         * @return the email
         */
        public String getEmail() {
            return email;
        }

        /**
         * @param email the email to set
         */
        public void setEmail(String email) {
            this.email = email;
        }

        /**
         * @return the phone
         */
        public String getPhone() {
            return phone;
        }

        /**
         * @param phone the phone to set
         */
        public void setPhone(String phone) {
            this.phone = phone;
        }
    }
    private SearchInput searchInput;
    
    private Account detailAccount;
    /**
     * Creates a new instance of EmpPanelMb
     */
    public EmpPanelMb() {
        System.out.println("Created new EmpPanelMb");
        searchInput = new SearchInput();
    }
    
    public void findAndSetDetail(String id){
        detailAccount = accountFacade.find(id);
        System.out.println(detailAccount.getUsername());
    }
    
    public void searchAllEmployee() {
        this.searchResult = accountFacade.findAll();
    }
    
    public void searchEmployee() {
        this.searchResult =
                accountFacade.searchFromInput(searchInput.username, 
                        departmentFacade.find(searchInput.searchDepartmentID),
                        searchInput.gender,
                        searchInput.isadmin,
                        searchInput.fullname,
                        searchInput.birthday,
                        searchInput.address,
                        searchInput.email,
                        searchInput.phone);
        
    }
    
    public void changePassword(String oldPassword, String newPassword, String repeatPassword) {
        try {
            if(loginMb.getPassword().equals(oldPassword)) {
                if(newPassword.length() < 5 || newPassword.length() > 30){
                    this.message = "Password must be between 5 and 30 characters";
                    return;
                }
                if(newPassword.equals(repeatPassword)) {
                    updateAccount.setPassword(newPassword);
                    accountFacade.edit(updateAccount);
                    this.message = "Password has been changed.";
                } else {
                    this.message = "New passwords don't match!";
                    return;
                }
            } else {
                this.message = "Old password is wrong!";
                return;
            }
                
        } catch (Exception e) {
            System.out.println(e.getMessage());
            this.message = "There has been an error while updating your password.";
        }
    }
    
    public void updateProfile() {
        try {
            updateAccount.setDepartmentID(departmentFacade.find(this.updateDepartmentID));
            accountFacade.edit(updateAccount);
            this.getLoginMb().setCurAccount(updateAccount);
            this.message = "Succesfully updated.";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            this.message = "There has been an error while updating your profile.";
        }
        
    }
    
    public List<Department> findAllDepartment() {
        return departmentFacade.findAll();
    }
    
    public String getRoleName() {
        if(this.updateAccount.getRole())
            return "Admin";
        else 
            return "Employee";
    }
    
    public String convertBooleanToRole(Boolean role) {
        if(role)
            return "Admin";
        else 
            return "Employee";
    }
    public String convertBooleanToGender(Boolean gender) {
        if(gender)
            return "Male";
        else 
            return "Female";
    }
    
    public String getSimpleDate(Date date) {
        return new aptech.util.DateConverter().getSimpleDateString(date);
    }
    
    @PostConstruct
    public void init() {
        // Put original constructor code here.
    }

    /**
     * @return the updateAccount
     */
    public Account getUpdateAccount() {
        return updateAccount;
    }

    /**
     * @param updateAccount the updateAccount to set
     */
    public void setUpdateAccount(Account updateAccount) {
        this.updateAccount = updateAccount;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the loginMb
     */
    public LoginMb getLoginMb() {
        return loginMb;
    }

    /**
     * @param loginMb the loginMb to set
     */
    public void setLoginMb(LoginMb loginMb) {
        this.loginMb = loginMb;
    }

    /**
     * @return the updateDepartmentID
     */
    public String getUpdateDepartmentID() {
        return this.updateAccount.getDepartmentID().getDepartmentID();
    }

    /**
     * @param updateDepartmentID the updateDepartmentID to set
     */
    public void setUpdateDepartmentID(String updateDepartmentID) {
        this.updateDepartmentID = updateDepartmentID;
    }


    /**
     * @return the searchResult
     */
    public List<Account> getSearchResult() {
        return searchResult;
    }

    /**
     * @param searchResult the searchResult to set
     */
    public void setSearchResult(List<Account> searchResult) {
        this.searchResult = searchResult;
    }
    
    /**
     * @return the searchInput
     */
    public SearchInput getSearchInput() {
        return searchInput;
    }

    /**
     * @param searchInput the searchInput to set
     */
    public void setSearchInput(SearchInput searchInput) {
        this.searchInput = searchInput;
    }
    
    /**
     * @return the detailAccount
     */
    public Account getDetailAccount() {
        return detailAccount;
    }

    /**
     * @param detailAccount the detailAccount to set
     */
    public void setDetailAccount(Account detailAccount) {
        this.detailAccount = detailAccount;
    }
}

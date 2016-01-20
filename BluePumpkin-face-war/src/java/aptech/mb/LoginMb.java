/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aptech.mb;

import aptech.entity.Account;
import aptech.sb.AccountFacadeLocal;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author NguyenDucHuy
 */
@ManagedBean
@SessionScoped
public class LoginMb {
    @EJB
    private AccountFacadeLocal accountFacade;

    private String username;
    private String password;
    private Account curAccount;
    
    /**
     * Creates a new instance of LoginMb
     */
    public LoginMb() {
        
    }
    
    public void login() {
        List<Account> accountList = accountFacade.findAll();
        Boolean check = false;
        for(Account account : accountList) {
            if(this.getUsername().equals(account.getUsername())) {
                if(this.getPassword().equals(account.getPassword())){
                    check = true;
                    this.curAccount = account;
                    break;
                }
            }
        }
        
        if(check) {
            try {
                redirect("index.xhtml");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } 
    }
    
    public void logout() throws IOException {
        this.curAccount = null;
        this.username = null;
        this.password = null;
        redirect("login.xhtml");
    }
    
    public void checkCurAccount() throws IOException {
        if(this.curAccount == null)
            redirect("login.xhtml");
    }
    
    public void redirect(String url) throws IOException {
        HttpServletRequest origRequest = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String context = origRequest.getContextPath();
        FacesContext.getCurrentInstance().getExternalContext().redirect(context + "/" + url);
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
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the curAccount
     */
    public Account getCurAccount() {
        return curAccount;
    }

    /**
     * @param curAccount the curAccount to set
     */
    public void setCurAccount(Account curAccount) {
        this.curAccount = curAccount;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aptech.sb;

import aptech.entity.Account;
import aptech.entity.Department;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author NguyenDucHuy
 */
@Stateless
public class AccountFacade extends AbstractFacade<Account> implements AccountFacadeLocal {
    @PersistenceContext(unitName = "BluePumpkin-face-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccountFacade() {
        super(Account.class);
    }

    @Override
    public List<Account> searchFromInput(String username, Department department, Boolean gender, Boolean isadmin, String fullname, Date birthday, String address, String email, String phone) {
        String queryString = "select a from Account a where "
                + "a.username like :username and "
                + "a.departmentID = :department and "
                + "a.role = :isadmin and "
                + "a.fullname like :fullname and "
                
                + "a.address like :address and "
                + "a.email like :email and "
                + "a.phone like :phone and "
                + "a.isBlocked = false";
        
        if(gender != null) {
            queryString += " and a.gender = :gender";
        }
        if(birthday != null) {
            queryString += " and a.birthday = :birthday";
        }
        
        Query query = em.createQuery(queryString);
        query.setParameter("username", "%"+username+"%");
        query.setParameter("department", department);
        query.setParameter("isadmin", isadmin);
        query.setParameter("fullname", "%"+fullname+"%");
        query.setParameter("address", "%"+address+"%");
        query.setParameter("email", "%"+email+"%");
        query.setParameter("phone", "%"+phone+"%");
        if(gender != null) {
            query.setParameter("gender", gender);
        }
        if(birthday != null) {
            query.setParameter("birthday", birthday);
        }
        
        System.out.println("Gender: " + gender + ", Birthday: " + birthday);
        return query.getResultList();
        
    }
    
}

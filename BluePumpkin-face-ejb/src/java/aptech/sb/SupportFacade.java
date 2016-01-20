/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aptech.sb;

import aptech.entity.Account;
import aptech.entity.Support;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author NguyenDucHuy
 */
@Stateless
public class SupportFacade extends AbstractFacade<Support> implements SupportFacadeLocal {
    @PersistenceContext(unitName = "BluePumpkin-face-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SupportFacade() {
        super(Support.class);
    }

    @Override
    public List<Support> search(String searchString, Date from, Date to, Account curAccount, Boolean isResolved) {
        String queryString = "select s from Support s where "
                + "s.username = :curAccount and "
                + "s.supportTitle like :searchString and "
                + "s.supportContent like :searchString and "
                + "s.isResolved = :isResolved and "
                + "s.dateCreate between :from and :to";
        Query query = em.createQuery(queryString);
        query.setParameter("curAccount", curAccount);
        query.setParameter("searchString", "%" + searchString + "%");
        query.setParameter("isResolved", isResolved);
        if(from == null) {
            query.setParameter("from", new GregorianCalendar(1111, 1, 1).getTime());
        } else {
            query.setParameter("from", from);
        }
        if(to == null) {
            query.setParameter("to", new Date());
        } else {
            query.setParameter("to", to);
        }
        
        
        try {
            return query.getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Boolean insert(String title, String content, String username) {
        String queryString = "insert into Support values(?,?,?,?,?)";
        Query query = em.createNativeQuery(queryString);
        query.setParameter(1, username);
        query.setParameter(2, new Date());
        query.setParameter(3, title);
        query.setParameter(4, content);
        query.setParameter(5, false);
        try {
            query.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    
}

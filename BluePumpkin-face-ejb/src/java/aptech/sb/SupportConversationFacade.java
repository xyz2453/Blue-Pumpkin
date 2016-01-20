/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aptech.sb;

import aptech.entity.Support;
import aptech.entity.SupportConversation;
import java.util.Date;
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
public class SupportConversationFacade extends AbstractFacade<SupportConversation> implements SupportConversationFacadeLocal {
    @PersistenceContext(unitName = "BluePumpkin-face-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SupportConversationFacade() {
        super(SupportConversation.class);
    }

    @Override
    public List<SupportConversation> findBySupportID(Support support) {
        String queryString = "select s from SupportConversation s where "
                + "s.supportID = :support";
        
        Query query = em.createQuery(queryString);
        query.setParameter("support", support);
        
        try {
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Boolean sendReply(String content, String username, int supportID) {
        String queryString = "insert into SupportConversation values (?,?,?,?)";
        Query query = em.createNativeQuery(queryString);
        query.setParameter(1, supportID);
        query.setParameter(2, username);
        query.setParameter(3, new Date());
        query.setParameter(4, content);
        
        try {
            query.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        
    }
    
}

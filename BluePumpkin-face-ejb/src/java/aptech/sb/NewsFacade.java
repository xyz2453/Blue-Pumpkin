/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aptech.sb;

import aptech.entity.News;
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
public class NewsFacade extends AbstractFacade<News> implements NewsFacadeLocal {
    @PersistenceContext(unitName = "BluePumpkin-face-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NewsFacade() {
        super(News.class);
    }

    @Override
    public List<News> quickSearch(String searchString) {
        String queryString = "select n from News n where "
                + "n.newsTitle like :searchString or "
                + "n.newsContent like :searchString";
        
        Query query = em.createQuery(queryString);
        query.setParameter("searchString", "%" + searchString + "%");
        
        try {
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
        
    }

    @Override
    public List<News> search(String searchTitle, String searchContent, String searchAuthor, Date searchFrom, Date searchTo) {
        String queryString = "select n from News n where "
                + "n.newsTitle like :searchTitle and "
                + "n.newsContent like :searchContent and "
                + "n.username.fullname like :searchAuthor ";
        if(searchFrom == null) {
            searchFrom = new GregorianCalendar(1111, 1, 1).getTime();
        }
        if(searchTo == null) {
            searchTo = new Date();
        }
        queryString += "and n.dateCreate between :searchFrom and :searchTo";
        
        Query query = em.createQuery(queryString);
        query.setParameter("searchTitle", "%" + searchTitle + "%");
        query.setParameter("searchContent", "%" + searchContent + "%");
        query.setParameter("searchAuthor", "%" + searchAuthor + "%");
        query.setParameter("searchFrom", searchFrom);
        query.setParameter("searchTo", searchTo);
        
        System.out.println(searchFrom + "\n" + searchTo);
        
        try {
            List<News> result = query.getResultList();
            System.out.println("Found: " + result.size());
            return result;
        } catch (Exception e) {
            return null;
        }    
    
    }

    @Override
    public Boolean insert(News createNews) {
        try {
            String queryString = "insert into News values (?,?,?,?,?)";
            Query query = em.createNativeQuery(queryString);
            query.setParameter(1, createNews.getUsername().getUsername());
            query.setParameter(2,  createNews.getDateCreate());
            query.setParameter(3, createNews.getNewsTitle() );
            query.setParameter(4, createNews.getNewsContent());
            query.setParameter(5, createNews.getNewsThumbnail());
            
            query.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }
    
    
    
}

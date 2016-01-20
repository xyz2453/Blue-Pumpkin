/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aptech.sb;

import aptech.entity.News;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author NguyenDucHuy
 */
@Local
public interface NewsFacadeLocal {

    void create(News news);

    void edit(News news);

    void remove(News news);

    News find(Object id);

    List<News> findAll();

    List<News> findRange(int[] range);

    int count();
    
    List<News> quickSearch(String searchString);
    List<News> search(String searchTitle, String searchContent, String searchAuthor, Date searchFrom, Date searchTo);
    Boolean insert(News createNews);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aptech.sb;

import aptech.entity.Account;
import aptech.entity.Support;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author NguyenDucHuy
 */
@Local
public interface SupportFacadeLocal {

    void create(Support support);

    void edit(Support support);

    void remove(Support support);

    Support find(Object id);

    List<Support> findAll();

    List<Support> findRange(int[] range);

    int count();
    
    List<Support> search(String searchString, Date from, Date to, Account curAccount, Boolean isResolved);
    Boolean insert(String title, String content, String username);
}

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
import javax.ejb.Local;

/**
 *
 * @author NguyenDucHuy
 */
@Local
public interface AccountFacadeLocal {

    void create(Account account);

    void edit(Account account);

    void remove(Account account);

    Account find(Object id);

    List<Account> findAll();

    List<Account> findRange(int[] range);

    int count();
    
    List<Account> searchFromInput(String username, Department department, Boolean gender, Boolean isadmin, String fullname, Date birthday, String address, String email, String phone);
}

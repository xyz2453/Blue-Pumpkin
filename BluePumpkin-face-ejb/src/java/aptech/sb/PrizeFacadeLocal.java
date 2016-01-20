/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aptech.sb;

import aptech.entity.Prize;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author NguyenDucHuy
 */
@Local
public interface PrizeFacadeLocal {

    void create(Prize prize);

    void edit(Prize prize);

    void remove(Prize prize);

    Prize find(Object id);

    List<Prize> findAll();

    List<Prize> findRange(int[] range);

    int count();
    
}

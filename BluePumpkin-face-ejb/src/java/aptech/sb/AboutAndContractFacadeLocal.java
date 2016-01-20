/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aptech.sb;

import aptech.entity.AboutAndContract;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author NguyenDucHuy
 */
@Local
public interface AboutAndContractFacadeLocal {

    void create(AboutAndContract aboutAndContract);

    void edit(AboutAndContract aboutAndContract);

    void remove(AboutAndContract aboutAndContract);

    AboutAndContract find(Object id);

    List<AboutAndContract> findAll();

    List<AboutAndContract> findRange(int[] range);

    int count();
    
}

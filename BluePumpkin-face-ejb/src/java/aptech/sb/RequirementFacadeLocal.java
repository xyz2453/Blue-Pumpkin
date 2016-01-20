/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aptech.sb;

import aptech.entity.Requirement;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author NguyenDucHuy
 */
@Local
public interface RequirementFacadeLocal {

    void create(Requirement requirement);

    void edit(Requirement requirement);

    void remove(Requirement requirement);

    Requirement find(Object id);

    List<Requirement> findAll();

    List<Requirement> findRange(int[] range);

    int count();
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aptech.sb;

import aptech.entity.GroupWinner;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author NguyenDucHuy
 */
@Local
public interface GroupWinnerFacadeLocal {

    void create(GroupWinner groupWinner);

    void edit(GroupWinner groupWinner);

    void remove(GroupWinner groupWinner);

    GroupWinner find(Object id);

    List<GroupWinner> findAll();

    List<GroupWinner> findRange(int[] range);

    int count();
    
}

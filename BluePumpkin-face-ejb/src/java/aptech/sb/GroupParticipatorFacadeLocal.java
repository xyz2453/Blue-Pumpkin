/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aptech.sb;

import aptech.entity.GroupParticipator;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author NguyenDucHuy
 */
@Local
public interface GroupParticipatorFacadeLocal {

    void create(GroupParticipator groupParticipator);

    void edit(GroupParticipator groupParticipator);

    void remove(GroupParticipator groupParticipator);

    GroupParticipator find(Object id);

    List<GroupParticipator> findAll();

    List<GroupParticipator> findRange(int[] range);

    int count();
    
}

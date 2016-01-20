/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aptech.sb;

import aptech.entity.EventGroupMember;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author NguyenDucHuy
 */
@Local
public interface EventGroupMemberFacadeLocal {

    void create(EventGroupMember eventGroupMember);

    void edit(EventGroupMember eventGroupMember);

    void remove(EventGroupMember eventGroupMember);

    EventGroupMember find(Object id);

    List<EventGroupMember> findAll();

    List<EventGroupMember> findRange(int[] range);

    int count();
    
}

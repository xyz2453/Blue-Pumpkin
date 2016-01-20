/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aptech.sb;

import aptech.entity.EventGroup;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author NguyenDucHuy
 */
@Local
public interface EventGroupFacadeLocal {

    void create(EventGroup eventGroup);

    void edit(EventGroup eventGroup);

    void remove(EventGroup eventGroup);

    EventGroup find(Object id);

    List<EventGroup> findAll();

    List<EventGroup> findRange(int[] range);

    int count();
    
}

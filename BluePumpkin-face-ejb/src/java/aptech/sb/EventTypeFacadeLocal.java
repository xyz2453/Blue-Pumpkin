/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aptech.sb;

import aptech.entity.EventType;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author NguyenDucHuy
 */
@Local
public interface EventTypeFacadeLocal {

    void create(EventType eventType);

    void edit(EventType eventType);

    void remove(EventType eventType);

    EventType find(Object id);

    List<EventType> findAll();

    List<EventType> findRange(int[] range);

    int count();
    
}

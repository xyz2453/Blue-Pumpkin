/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aptech.sb;

import aptech.entity.SoloParticipator;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author NguyenDucHuy
 */
@Local
public interface SoloParticipatorFacadeLocal {

    void create(SoloParticipator soloParticipator);

    void edit(SoloParticipator soloParticipator);

    void remove(SoloParticipator soloParticipator);

    SoloParticipator find(Object id);

    List<SoloParticipator> findAll();

    List<SoloParticipator> findRange(int[] range);

    int count();
    
}

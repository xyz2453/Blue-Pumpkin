/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aptech.sb;

import aptech.entity.SoloWinner;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author NguyenDucHuy
 */
@Local
public interface SoloWinnerFacadeLocal {

    void create(SoloWinner soloWinner);

    void edit(SoloWinner soloWinner);

    void remove(SoloWinner soloWinner);

    SoloWinner find(Object id);

    List<SoloWinner> findAll();

    List<SoloWinner> findRange(int[] range);

    int count();
    
}

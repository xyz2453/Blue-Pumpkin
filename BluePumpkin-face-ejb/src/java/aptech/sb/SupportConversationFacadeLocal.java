/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aptech.sb;

import aptech.entity.Support;
import aptech.entity.SupportConversation;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author NguyenDucHuy
 */
@Local
public interface SupportConversationFacadeLocal {

    void create(SupportConversation supportConversation);

    void edit(SupportConversation supportConversation);

    void remove(SupportConversation supportConversation);

    SupportConversation find(Object id);

    List<SupportConversation> findAll();

    List<SupportConversation> findRange(int[] range);

    int count();
    
    List<SupportConversation> findBySupportID(Support support);
    Boolean sendReply(String content, String username, int supportID);
    
}

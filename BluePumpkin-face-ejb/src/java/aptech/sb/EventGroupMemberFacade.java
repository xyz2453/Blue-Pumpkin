/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aptech.sb;

import aptech.entity.EventGroupMember;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author NguyenDucHuy
 */
@Stateless
public class EventGroupMemberFacade extends AbstractFacade<EventGroupMember> implements EventGroupMemberFacadeLocal {
    @PersistenceContext(unitName = "BluePumpkin-face-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EventGroupMemberFacade() {
        super(EventGroupMember.class);
    }
    
}

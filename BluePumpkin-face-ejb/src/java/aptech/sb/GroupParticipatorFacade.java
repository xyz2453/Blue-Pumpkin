/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aptech.sb;

import aptech.entity.GroupParticipator;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author NguyenDucHuy
 */
@Stateless
public class GroupParticipatorFacade extends AbstractFacade<GroupParticipator> implements GroupParticipatorFacadeLocal {
    @PersistenceContext(unitName = "BluePumpkin-face-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GroupParticipatorFacade() {
        super(GroupParticipator.class);
    }
    
}

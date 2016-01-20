package aptech.entity;

import aptech.entity.Account;
import aptech.entity.Event;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2016-01-19T12:46:57")
@StaticMetamodel(SoloParticipator.class)
public class SoloParticipator_ { 

    public static volatile SingularAttribute<SoloParticipator, Event> eventID;
    public static volatile SingularAttribute<SoloParticipator, Integer> soloParticipatorID;
    public static volatile SingularAttribute<SoloParticipator, Date> regDate;
    public static volatile SingularAttribute<SoloParticipator, Boolean> isPending;
    public static volatile SingularAttribute<SoloParticipator, Account> username;

}
package aptech.entity;

import aptech.entity.Event;
import aptech.entity.EventGroup;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2016-01-19T12:46:57")
@StaticMetamodel(GroupParticipator.class)
public class GroupParticipator_ { 

    public static volatile SingularAttribute<GroupParticipator, Event> eventID;
    public static volatile SingularAttribute<GroupParticipator, EventGroup> groupID;
    public static volatile SingularAttribute<GroupParticipator, Integer> groupParticipatorID;
    public static volatile SingularAttribute<GroupParticipator, Date> regDate;
    public static volatile SingularAttribute<GroupParticipator, Boolean> isPending;

}
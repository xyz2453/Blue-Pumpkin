package aptech.entity;

import aptech.entity.EventGroupMember;
import aptech.entity.GroupParticipator;
import aptech.entity.GroupWinner;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2016-01-19T12:46:57")
@StaticMetamodel(EventGroup.class)
public class EventGroup_ { 

    public static volatile SingularAttribute<EventGroup, String> groupName;
    public static volatile SingularAttribute<EventGroup, String> groupDescription;
    public static volatile SingularAttribute<EventGroup, Integer> groupID;
    public static volatile ListAttribute<EventGroup, GroupParticipator> groupParticipatorList;
    public static volatile SingularAttribute<EventGroup, Date> dateCreate;
    public static volatile ListAttribute<EventGroup, EventGroupMember> eventGroupMemberList;
    public static volatile ListAttribute<EventGroup, GroupWinner> groupWinnerList;

}
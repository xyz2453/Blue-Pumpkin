package aptech.entity;

import aptech.entity.Account;
import aptech.entity.EventGroup;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2016-01-19T12:46:57")
@StaticMetamodel(EventGroupMember.class)
public class EventGroupMember_ { 

    public static volatile SingularAttribute<EventGroupMember, Boolean> isLeader;
    public static volatile SingularAttribute<EventGroupMember, EventGroup> groupID;
    public static volatile SingularAttribute<EventGroupMember, Integer> eventGroupMemberID;
    public static volatile SingularAttribute<EventGroupMember, Boolean> isPending;
    public static volatile SingularAttribute<EventGroupMember, Account> username;

}
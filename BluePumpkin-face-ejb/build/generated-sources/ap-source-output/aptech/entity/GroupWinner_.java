package aptech.entity;

import aptech.entity.Event;
import aptech.entity.EventGroup;
import aptech.entity.Prize;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2016-01-19T12:46:57")
@StaticMetamodel(GroupWinner.class)
public class GroupWinner_ { 

    public static volatile SingularAttribute<GroupWinner, Event> eventID;
    public static volatile SingularAttribute<GroupWinner, EventGroup> groupID;
    public static volatile SingularAttribute<GroupWinner, Integer> groupWinnerID;
    public static volatile SingularAttribute<GroupWinner, Prize> prizeID;

}
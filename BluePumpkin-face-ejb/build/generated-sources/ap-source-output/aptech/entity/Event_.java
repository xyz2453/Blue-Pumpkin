package aptech.entity;

import aptech.entity.Account;
import aptech.entity.EventType;
import aptech.entity.GroupParticipator;
import aptech.entity.GroupWinner;
import aptech.entity.Prize;
import aptech.entity.Requirement;
import aptech.entity.SoloParticipator;
import aptech.entity.SoloWinner;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2016-01-19T12:46:57")
@StaticMetamodel(Event.class)
public class Event_ { 

    public static volatile SingularAttribute<Event, Integer> eventID;
    public static volatile SingularAttribute<Event, String> eventContent;
    public static volatile ListAttribute<Event, GroupParticipator> groupParticipatorList;
    public static volatile SingularAttribute<Event, Date> dateCreate;
    public static volatile ListAttribute<Event, GroupWinner> groupWinnerList;
    public static volatile SingularAttribute<Event, String> eventTitle;
    public static volatile SingularAttribute<Event, EventType> eventTypeID;
    public static volatile ListAttribute<Event, Prize> prizeList;
    public static volatile SingularAttribute<Event, String> eventThumbnail;
    public static volatile ListAttribute<Event, SoloWinner> soloWinnerList;
    public static volatile SingularAttribute<Event, Requirement> requirementID;
    public static volatile ListAttribute<Event, SoloParticipator> soloParticipatorList;
    public static volatile SingularAttribute<Event, Account> username;

}
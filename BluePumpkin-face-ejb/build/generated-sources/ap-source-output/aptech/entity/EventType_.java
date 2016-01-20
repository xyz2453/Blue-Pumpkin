package aptech.entity;

import aptech.entity.Event;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2016-01-19T12:46:57")
@StaticMetamodel(EventType.class)
public class EventType_ { 

    public static volatile SingularAttribute<EventType, String> eventTypeID;
    public static volatile ListAttribute<EventType, Event> eventList;
    public static volatile SingularAttribute<EventType, String> eventTypeName;

}
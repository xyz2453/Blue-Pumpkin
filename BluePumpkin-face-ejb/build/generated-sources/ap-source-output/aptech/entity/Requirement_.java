package aptech.entity;

import aptech.entity.Event;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2016-01-19T12:46:57")
@StaticMetamodel(Requirement.class)
public class Requirement_ { 

    public static volatile SingularAttribute<Requirement, Integer> maxParticipator;
    public static volatile ListAttribute<Requirement, Event> eventList;
    public static volatile SingularAttribute<Requirement, Date> regEndDate;
    public static volatile SingularAttribute<Requirement, Boolean> gender;
    public static volatile SingularAttribute<Requirement, String> extraNote;
    public static volatile SingularAttribute<Requirement, Integer> maxMemberPerGroup;
    public static volatile SingularAttribute<Requirement, Integer> requirementID;
    public static volatile SingularAttribute<Requirement, Boolean> isGroup;
    public static volatile SingularAttribute<Requirement, Date> regStartDate;
    public static volatile SingularAttribute<Requirement, Date> eventStartDate;

}
package aptech.entity;

import aptech.entity.Event;
import aptech.entity.GroupWinner;
import aptech.entity.SoloWinner;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2016-01-19T12:46:57")
@StaticMetamodel(Prize.class)
public class Prize_ { 

    public static volatile SingularAttribute<Prize, Event> eventID;
    public static volatile SingularAttribute<Prize, String> prizeContent;
    public static volatile SingularAttribute<Prize, Integer> prizeOrder;
    public static volatile ListAttribute<Prize, SoloWinner> soloWinnerList;
    public static volatile SingularAttribute<Prize, Integer> prizeID;
    public static volatile ListAttribute<Prize, GroupWinner> groupWinnerList;

}
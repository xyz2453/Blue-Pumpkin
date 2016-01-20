package aptech.entity;

import aptech.entity.Account;
import aptech.entity.Event;
import aptech.entity.Prize;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2016-01-19T12:46:57")
@StaticMetamodel(SoloWinner.class)
public class SoloWinner_ { 

    public static volatile SingularAttribute<SoloWinner, Event> eventID;
    public static volatile SingularAttribute<SoloWinner, Integer> soloWinnerID;
    public static volatile SingularAttribute<SoloWinner, Prize> prizeID;
    public static volatile SingularAttribute<SoloWinner, Account> username;

}
package aptech.entity;

import aptech.entity.Department;
import aptech.entity.Event;
import aptech.entity.EventGroupMember;
import aptech.entity.News;
import aptech.entity.SoloParticipator;
import aptech.entity.SoloWinner;
import aptech.entity.Support;
import aptech.entity.SupportConversation;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2016-01-19T12:46:57")
@StaticMetamodel(Account.class)
public class Account_ { 

    public static volatile SingularAttribute<Account, Date> birthday;
    public static volatile SingularAttribute<Account, Boolean> role;
    public static volatile SingularAttribute<Account, String> address;
    public static volatile ListAttribute<Account, Event> eventList;
    public static volatile SingularAttribute<Account, Boolean> gender;
    public static volatile SingularAttribute<Account, Department> departmentID;
    public static volatile SingularAttribute<Account, Boolean> isBlocked;
    public static volatile ListAttribute<Account, Support> supportList;
    public static volatile ListAttribute<Account, EventGroupMember> eventGroupMemberList;
    public static volatile ListAttribute<Account, SupportConversation> supportConversationList;
    public static volatile ListAttribute<Account, News> newsList;
    public static volatile SingularAttribute<Account, String> password;
    public static volatile SingularAttribute<Account, String> phone;
    public static volatile ListAttribute<Account, SoloWinner> soloWinnerList;
    public static volatile SingularAttribute<Account, String> fullname;
    public static volatile SingularAttribute<Account, String> email;
    public static volatile SingularAttribute<Account, String> username;
    public static volatile ListAttribute<Account, SoloParticipator> soloParticipatorList;

}
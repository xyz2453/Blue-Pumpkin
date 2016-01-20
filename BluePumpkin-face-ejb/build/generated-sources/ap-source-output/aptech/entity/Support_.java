package aptech.entity;

import aptech.entity.Account;
import aptech.entity.SupportConversation;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2016-01-19T12:46:57")
@StaticMetamodel(Support.class)
public class Support_ { 

    public static volatile SingularAttribute<Support, String> supportTitle;
    public static volatile SingularAttribute<Support, String> supportContent;
    public static volatile SingularAttribute<Support, Integer> supportID;
    public static volatile SingularAttribute<Support, Date> dateCreate;
    public static volatile SingularAttribute<Support, Boolean> isResolved;
    public static volatile ListAttribute<Support, SupportConversation> supportConversationList;
    public static volatile SingularAttribute<Support, Account> username;

}
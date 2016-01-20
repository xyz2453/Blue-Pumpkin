package aptech.entity;

import aptech.entity.Account;
import aptech.entity.Support;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2016-01-19T12:46:57")
@StaticMetamodel(SupportConversation.class)
public class SupportConversation_ { 

    public static volatile SingularAttribute<SupportConversation, Support> supportID;
    public static volatile SingularAttribute<SupportConversation, Date> dateCreate;
    public static volatile SingularAttribute<SupportConversation, String> content;
    public static volatile SingularAttribute<SupportConversation, Integer> supportConversationID;
    public static volatile SingularAttribute<SupportConversation, Account> username;

}
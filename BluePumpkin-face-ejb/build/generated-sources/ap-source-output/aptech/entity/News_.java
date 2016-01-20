package aptech.entity;

import aptech.entity.Account;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2016-01-19T12:46:57")
@StaticMetamodel(News.class)
public class News_ { 

    public static volatile SingularAttribute<News, Integer> newsID;
    public static volatile SingularAttribute<News, String> newsContent;
    public static volatile SingularAttribute<News, String> newsTitle;
    public static volatile SingularAttribute<News, String> newsThumbnail;
    public static volatile SingularAttribute<News, Date> dateCreate;
    public static volatile SingularAttribute<News, Account> username;

}
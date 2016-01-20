package aptech.entity;

import aptech.entity.Account;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2016-01-19T12:46:57")
@StaticMetamodel(Department.class)
public class Department_ { 

    public static volatile SingularAttribute<Department, String> departmentName;
    public static volatile SingularAttribute<Department, String> departmentID;
    public static volatile ListAttribute<Department, Account> accountList;

}
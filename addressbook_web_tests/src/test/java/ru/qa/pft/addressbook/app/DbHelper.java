package ru.qa.pft.addressbook.app;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.engine.query.spi.sql.NativeSQLQueryReturn;
import org.openqa.selenium.WebDriver;
import ru.qa.pft.addressbook.model.ContactData;
import ru.qa.pft.addressbook.model.Contacts;
import ru.qa.pft.addressbook.model.GroupData;
import ru.qa.pft.addressbook.model.Groups;


import java.util.List;

public class DbHelper {

  private final SessionFactory sessionFactory;

  public DbHelper(WebDriver wd) {
    // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
    sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();


  }

  public Groups groups() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<GroupData> result = session.createQuery("from GroupData").list();
    for (GroupData group : result) {
      System.out.println(group);
    }
    session.getTransaction().commit();
    session.close();
    return new Groups(result);
  }

  public Contacts contacts() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<ContactData> result = session.createQuery("from ContactData where deprecated = '0000-00-00'").list();
    for (ContactData contact : result) {
      System.out.println(contact);
    }
    session.getTransaction().commit();
    session.close();
    return new Contacts(result);
  }

  public int GetFreeContact(){
    int contactId = -1;
    Session session = sessionFactory.openSession();
    session.beginTransaction();

    SQLQuery q = session.createSQLQuery("select distinct ab.id, ab.email from addressbook ab left outer join address_in_groups ag on ab.id = ag.id where ag.group_id is null;");
    List<Object[]> r = q.list();
    if(r.size() > 0){
      contactId = (int)r.get(0)[0];
    }
    session.getTransaction().commit();
    session.close();
    return contactId;
  }
}

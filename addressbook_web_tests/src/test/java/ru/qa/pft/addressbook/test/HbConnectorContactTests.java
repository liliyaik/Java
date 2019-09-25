package ru.qa.pft.addressbook.test;

        import org.hibernate.Session;
        import org.hibernate.SessionFactory;
        import org.hibernate.boot.MetadataSources;
        import org.hibernate.boot.registry.StandardServiceRegistry;
        import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
        import org.testng.annotations.BeforeClass;
        import org.testng.annotations.Test;
        import ru.qa.pft.addressbook.model.ContactData;
        import ru.qa.pft.addressbook.model.Contacts;

        import java.util.List;

public class HbConnectorContactTests {

  private SessionFactory sessionFactory;

  @BeforeClass
  protected void setUp() throws Exception {
    // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
    sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();

  }

  @Test
  public Contacts testHbConnectionContact(){
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<ContactData> result = session.createQuery( "from ContactData where deprecated=0000-00-00" ).list();
    session.getTransaction().commit();
    session.close();

    return new Contacts(result);

  }
}
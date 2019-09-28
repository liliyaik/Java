package ru.qa.pft.addressbook.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.qa.pft.addressbook.model.ContactData;
import ru.qa.pft.addressbook.model.Contacts;
import ru.qa.pft.addressbook.model.GroupData;
import ru.qa.pft.addressbook.model.Groups;

import java.util.Set;

public class ContactRemoveGroupTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    app.contact().gotoHomepage();
    if (app.db().groups().size() == 0) {
      app.goTo().gotoGroupPage();
      app.group().creatorGroup(new GroupData().withName("test111").withFooter("footer1").withHeader("header1"));
    }
    if (app.db().contacts().size() == 0) {
      app.goTo().gotoContactPage();
      app.contact().creatorNewContact(new ContactData().withFirstname("name").withLastname("Iksanova").withNickname("limma").withAddress("Moscow"));
    }
  }

  @Test
  public void testContactRemoveGroup(){
    Groups groups = app.db().groups();
    Contacts before = app.db().contacts();
    ContactData removedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(removedContact.getId()).inGroup(groups.iterator().next());
    if(contact.getGroups().size() == 0){
      app.contact().addgroup(contact);
    }
    Set<GroupData> contactgroups = (Set<GroupData>) contact.getGroups();
    GroupData groupToRemove = contactgroups.iterator().next();
    GroupData group = new GroupData().withId(groupToRemove.getId());
    app.contact().removefromgroup(contact, group);
  }
}


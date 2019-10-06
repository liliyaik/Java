package ru.qa.pft.addressbook.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.qa.pft.addressbook.model.ContactData;
import ru.qa.pft.addressbook.model.Contacts;
import ru.qa.pft.addressbook.model.GroupData;
import ru.qa.pft.addressbook.model.Groups;

import java.security.acl.Group;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ContactRemoveGroupTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
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
    Contacts contacts = app.db().contacts();
    ContactData deletedContact = contacts.iterator().next();
    Groups groupsOfDeletedContact = deletedContact.getGroups();
    if (deletedContact.getGroups().size() == 0) {
      GroupData g = groups.iterator().next();
      app.contact().addContact(deletedContact, g);
      groupsOfDeletedContact = groupsOfDeletedContact.withAdded(g);
    }
    GroupData linkedGroup = groupsOfDeletedContact.iterator().next();
    app.contact().removefromgroup(deletedContact, linkedGroup);
    ContactData contactsAfter = app.db().selectContactFromDbById(deletedContact.getId()).iterator().next();
    Groups groupsOfDeletedContactAfter = contactsAfter.getGroups();
    assertThat(groupsOfDeletedContact.without(linkedGroup), equalTo(groupsOfDeletedContactAfter));
  }
}


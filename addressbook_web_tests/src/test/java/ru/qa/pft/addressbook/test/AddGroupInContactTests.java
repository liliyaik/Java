package ru.qa.pft.addressbook.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.qa.pft.addressbook.model.ContactData;
import ru.qa.pft.addressbook.model.Contacts;
import ru.qa.pft.addressbook.model.GroupData;
import ru.qa.pft.addressbook.model.Groups;
import java.util.Set;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.testng.Assert.assertEquals;
import static ru.qa.pft.addressbook.test.TestBase.app;

public class AddGroupInContactTests extends TestBase {
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


//    @Test
//    public void testsAddGroupInContact2(){
//      Groups groups = app.db().groups();
//      Contacts before = app.db().contacts();
//      ContactData addedContact = before.iterator().next();
//      ContactData contact = new ContactData().withId(addedContact.getId()).inGroup(groups.iterator().next());
//      app.contact().addgroup(contact);
//      Contacts after = app.db().contacts();
//      assertEquals(after.size(), before.size());
//      assertEquals(contact.getGroups().size(), app.db().groups().size());
//  }
  @Test
  public void testsAddGroupInContact(){
    Contacts contacts = app.db().contacts();
    ContactData addedContact = contacts.iterator().next();
    Groups groups = app.db().groups();
    GroupData linkedGroup = groups.iterator().next();
    Groups groupsOfAddedContact = addedContact.getGroups();
    Iterator<ContactData> iterator = contacts.iterator();
    while (iterator.hasNext()) {
      if (groupsOfAddedContact.equals(groups)) {
        addedContact = iterator.next();
        groupsOfAddedContact = addedContact.getGroups();
      } else {
        break;
      }
    }
    if (groupsOfAddedContact.equals(groups)) {
      app.goTo().gotoGroupPage();
      linkedGroup = new GroupData().withName("test222").withFooter("footer2").withHeader("header2");
      app.group().creatorGroup(linkedGroup);
      app.contact().addContact(addedContact, linkedGroup);
    }
    app.contact().addContact(addedContact, linkedGroup);
    ContactData contactsAfter = app.db().selectContactFromDbById(addedContact.getId()).iterator().next();
    Groups groupsOfAddedContactAfter = contactsAfter.getGroups();
    assertThat(groupsOfAddedContact.withAdded(linkedGroup), equalTo(groupsOfAddedContactAfter));
  }

}



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

    @Test
  public void testsAddGroupInContact(){
    //Contacts contacts = app.db().contacts();
    ContactData addedContact = app.contact().GetFreeContact();
    if(addedContact == null){
      app.contact().creatorNewContact(new ContactData().withFirstname("name").withLastname("Iksanova").withNickname("limma").withAddress("Moscow"));
      addedContact = app.contact().GetFreeContact();
    }
    Groups groups = app.db().groups();
    Groups groupsOfAddedContact = addedContact.getGroups();
    if(groupsOfAddedContact.size() > 0) {
      groups.removeAll(groupsOfAddedContact);
    }
    GroupData linkedGroup = groups.iterator().next();
    app.contact().addContact(addedContact, linkedGroup);
    ContactData contactsAfter = app.db().selectContactFromDbById(addedContact.getId()).iterator().next();
    Groups groupsOfAddedContactAfter = contactsAfter.getGroups();
    assertThat(groupsOfAddedContact.withAdded(linkedGroup), equalTo(groupsOfAddedContactAfter));
  }

}



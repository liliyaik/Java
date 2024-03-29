package ru.qa.pft.addressbook.test;

import org.testng.annotations.*;
import ru.qa.pft.addressbook.model.ContactData;
import ru.qa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.AssertJUnit.assertEquals;

public class ModificationContactTestBase extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
      if(app.db().contacts().size() == 0)
      {
      app.goTo().homePage();
      app.contact().creatorNewContact (new ContactData().withFirstname("name").withLastname("Iksanova").withNickname("limma").withAddress("Moscow"));
      }
    }

    @Test
    public void testContactModification(){
      Contacts before = app.db().contacts();
      ContactData modifiedContact = before.iterator().next();
      ContactData contact = new ContactData()
              .withId(modifiedContact.getId()).withFirstname("name2").withLastname("Iksanova2").withNickname("limma2").withAddress("Moscow");

      app.contact().modify(before, contact);
      Contacts after = app.db().contacts();
      assertEquals(after.size(), before.size());
      assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }

}
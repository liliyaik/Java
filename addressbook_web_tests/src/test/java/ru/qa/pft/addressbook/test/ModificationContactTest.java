package ru.qa.pft.addressbook.test;

import org.testng.annotations.*;
import ru.qa.pft.addressbook.model.Contacts;
import ru.qa.pft.addressbook.model.GroupDataContact;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.AssertJUnit.assertEquals;

public class ModificationContactTest extends BaseTest {

    @BeforeMethod
    public void ensurePreconditions(){
      app.goTo().homePage();
      if(app.contact().all().size() == 0){
        app.contact().creatorNewContact (new GroupDataContact().withName("name").withFio("Iksanova").withNik("limma").withCity("Moscow").withEmail("limma@yandex.ru"));
      }
    }

    @Test
    public void testContactModification(){
      Contacts before = app.contact().all();
      GroupDataContact modifiedContact = before.iterator().next();
        GroupDataContact contact = new GroupDataContact()
              .withId(modifiedContact.getId()).withName("name").withFio("Iksanova").withNik("limma").withCity("Moscow").withEmail("limma@yandex.ru");

      app.contact().modify(before, contact);

      Contacts after = app.contact().all();
      assertEquals(after.size(), before.size());
      assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }

}
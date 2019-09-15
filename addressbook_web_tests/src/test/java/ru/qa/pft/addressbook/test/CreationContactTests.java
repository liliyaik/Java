package ru.qa.pft.addressbook.test;

import org.testng.annotations.*;
import ru.qa.pft.addressbook.model.ContactData;
import ru.qa.pft.addressbook.model.Contacts;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreationContactTests extends TestBase {

  @Test(enabled = true)
  public void testCreationContact() throws Exception {

    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("name").withLastname("Iksanova").withNickname("limma").withAddress("Moscow").withEmails("limma@yandex.ru");
    app.contact().creatorNewContact(contact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> (g).getId()).max().getAsInt()))));

  }

}


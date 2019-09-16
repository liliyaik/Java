package ru.qa.pft.addressbook.test;

import org.testng.annotations.*;
import ru.qa.pft.addressbook.model.ContactData;
import ru.qa.pft.addressbook.model.Contacts;


import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreationContactTests extends TestBase {

  @Test(enabled = true)
  public void testCreationContact() throws Exception {

    File photo = new File("src/test/resources/imgcat.jpg");
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("Liliya").withLastname("Iksanova").withNickname("limma").withCompany("company").withAddress("Moscow").withMobilephone("9778046498").withPhoto(photo);
    app.contact().creatorNewContact(contact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));

//    assertThat(after, equalTo
//            (before.withAdded(contact.withId(after.stream().mapToInt(g -> g.getId()).max().getAsInt()))));
  }



}


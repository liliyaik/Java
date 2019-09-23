package ru.qa.pft.addressbook.test;

import org.testng.annotations.*;
import ru.qa.pft.addressbook.model.ContactData;
import ru.qa.pft.addressbook.model.Contacts;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.AssertJUnit.assertEquals;

public class DeleteContactTestBase extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();
    if(app.contact().all().size() == 0){
      app.contact().creatorNewContact (new ContactData().withFirstname("name").withLastname("Iksanova").withNickname("limma").withAddress("Moscow"));
  }
  }

  @Test
  public void testContactDeletion() throws Exception {

    Contacts before = app.contact().all();
    ContactData deletedContact =  before.iterator().next();
    app.contact().delete(deletedContact);
    Contacts after = app.contact().all();
    assertEquals(after.size(), before.size() - 1);
    assertThat(after, equalTo(before.without(deletedContact)));
  }

}

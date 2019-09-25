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
    if(app.db().contacts().size() == 0)
    {
    app.goTo().homePage();
    app.contact().creatorNewContact (new ContactData().withFirstname("name").withLastname("Iksanova").withNickname("limma").withAddress("Moscow"));
  }
  }

  @Test
  public void testContactDeletion() throws Exception {

    Contacts before = app.db().contacts();
    ContactData deletedContact =  before.iterator().next();
    app.contact().delete(deletedContact);
    Contacts after = app.db().contacts();
    assertEquals(after.size(), before.size() - 1);
    assertThat(after, equalTo(before.without(deletedContact)));
  }

}

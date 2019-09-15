package ru.qa.pft.addressbook.test;

import org.testng.annotations.*;
import ru.qa.pft.addressbook.model.Contacts;
import ru.qa.pft.addressbook.model.GroupDataContact;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.AssertJUnit.assertEquals;

public class DeleteContactTest extends BaseTest {

  @BeforeMethod
  public void ensurePreconditions(){
    app.getNavigationHelper().gotoHomePage();
    if(app.getContactHelper().all().size() == 0){
      app.getContactHelper().creatorNewContact (new GroupDataContact().withName("name").withFio("Iksanova").withNik("limma").withCity("Moscow").withEmail("limma@yandex.ru"));
  }
  }

  @Test
  public void testContactDeletion() throws Exception {

    Contacts before = app.getContactHelper().all();
    GroupDataContact deletedContact =  before.iterator().next();
    app.getContactHelper().delete(deletedContact);
    Contacts after = app.getContactHelper().all();
    assertEquals(after.size(), before.size() - 1);
    assertThat(after, equalTo(before.without(deletedContact)));
  }

}

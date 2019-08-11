package ru.qa.pft.addressbook.test;

import org.testng.annotations.*;
import ru.qa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends BaseTest {

  @Test
  public void testGroupCreation() throws Exception {

    app.gotoGroupPage("groups");
    app.initGroupCreation("new");
    app.fillGroupForm(new GroupData("test1", "test2", "test3"));
    app.submitGrouCreation("submit");
    app.returmGroupPage("group page");
    app.logout("Logout");
  }

}

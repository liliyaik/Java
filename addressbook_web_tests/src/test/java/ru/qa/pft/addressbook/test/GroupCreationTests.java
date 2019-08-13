package ru.qa.pft.addressbook.test;

import org.testng.annotations.*;
import ru.qa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends BaseTest {

  @Test
  public void testGroupCreation() throws Exception {

    app.gotoGroupPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
    app.getGroupHelper().submitGrouCreation();
    app.getGroupHelper().returmGroupPage();
    app.logout();
  }

}

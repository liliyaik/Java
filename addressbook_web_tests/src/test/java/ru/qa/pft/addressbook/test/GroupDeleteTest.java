package ru.qa.pft.addressbook.test;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import ru.qa.pft.addressbook.model.GroupData;

public class GroupDeleteTest extends BaseTest {

  @Test
  public void testGroupDelete() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup())
    {
      app.getGroupHelper().creatorGroup(new GroupData("test_name", "test_surname", "test3", "test1"));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().DeleteSelectionGroup();
    app.getGroupHelper().returmGroupPage();
    app.logout();
  }

}

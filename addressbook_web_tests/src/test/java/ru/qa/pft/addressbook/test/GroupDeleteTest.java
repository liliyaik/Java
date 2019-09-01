package ru.qa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import ru.qa.pft.addressbook.model.GroupData;

public class GroupDeleteTest extends BaseTest {

  @Test
  public void testGroupDelete() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupSize();
    if (! app.getGroupHelper().isThereAGroup())
    {
      app.getGroupHelper().creatorGroup(new GroupData("test_name", "test_surname", "test3", "test1"));
    }
    app.getGroupHelper().selectGroup(before);
    app.getGroupHelper().DeleteSelectionGroup();
    app.getGroupHelper().returmGroupPage();
    int after = app.getGroupHelper().getGroupSize();
    Assert.assertEquals(after, before - 1);
    app.logout();
  }

}

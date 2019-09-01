package ru.qa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import ru.qa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeleteTest extends BaseTest {

  @Test
  public void testGroupDelete() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup())
    {
      app.getGroupHelper().creatorGroup(new GroupData("test_name", "test_surname", "test3", "test1"));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().DeleteSelectionGroup();
    app.getGroupHelper().returmGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() - 1);
    app.logout();
  }

}

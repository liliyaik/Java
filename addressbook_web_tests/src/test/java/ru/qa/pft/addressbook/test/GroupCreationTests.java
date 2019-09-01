package ru.qa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.qa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupCreationTests extends BaseTest {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().creatorGroup(new GroupData("test_name", "test_surname", "test3", "test1"));
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);
  }

}

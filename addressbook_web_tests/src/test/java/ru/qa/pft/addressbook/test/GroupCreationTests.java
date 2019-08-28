package ru.qa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.qa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends BaseTest {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupSize();
    app.getGroupHelper().creatorGroup(new GroupData("test_name", "test_surname", "test3", "test1"));
    int after = app.getGroupHelper().getGroupSize();
    Assert.assertEquals(after, before + 1);
  }

}

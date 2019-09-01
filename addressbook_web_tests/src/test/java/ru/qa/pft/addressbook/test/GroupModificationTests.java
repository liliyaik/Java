package ru.qa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.qa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupModificationTests extends BaseTest {

  @Test
  public void testGroupModification()
  {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup())
    {
      app.getGroupHelper().creatorGroup(new GroupData("test_name", "test_surname", "test3", "test1"));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("test1", "test2", "test3", null));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returmGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());
  }
}

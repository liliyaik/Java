package ru.qa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.qa.pft.addressbook.model.GroupData;

public class GroupModificationTests extends BaseTest {

  @Test
  public void testGroupModification()
  {
    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupSize();
    if (! app.getGroupHelper().isThereAGroup())
    {
      app.getGroupHelper().creatorGroup(new GroupData("test_name", "test_surname", "test3", "test1"));
    }
    app.getGroupHelper().selectGroup(before - 1);
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("test1", "test2", "test3", null));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returmGroupPage();
    int after = app.getGroupHelper().getGroupSize();
    Assert.assertEquals(after, before);
  }
}

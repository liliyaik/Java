package ru.qa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.qa.pft.addressbook.model.GroupData;

public class GroupModificationTests extends BaseTest {

  @Test
  public void testGroupModification()
  {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returmGroupPage();

  }
}

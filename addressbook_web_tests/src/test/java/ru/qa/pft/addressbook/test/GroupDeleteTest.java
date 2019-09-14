package ru.qa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import ru.qa.pft.addressbook.model.GroupData;

import java.util.List;
import java.util.Set;

public class GroupDeleteTest extends BaseTest {

  @BeforeMethod
  public void ensurePrecondition(){
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup())
    {
      app.getGroupHelper().creatorGroup(new GroupData().withName("test_name3").withHeader("test_surname").withFooter("test3"));
    }
  }

  @Test
  public void testGroupDelete() throws Exception {

    Set<GroupData> before = app.getGroupHelper().all();
    GroupData deleteGroup = before.iterator().next();
    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().deleteSelectionGroup(deleteGroup);
    app.getGroupHelper().returmGroupPage();
    Set<GroupData> after = app.getGroupHelper().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deleteGroup);
    Assert.assertEquals(before, after);
  }

}

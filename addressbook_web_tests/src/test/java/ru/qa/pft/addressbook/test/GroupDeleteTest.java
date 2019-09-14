package ru.qa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import ru.qa.pft.addressbook.model.GroupData;

import java.util.List;

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

    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().DeleteSelectionGroup();
    app.getGroupHelper().returmGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
    //app.logout();
  }

}

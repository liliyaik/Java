package ru.qa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.qa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupModificationTests extends BaseTest {

  @BeforeMethod
  public void ensurePrecondition(){
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup())
    {
      app.getGroupHelper().creatorGroup(new GroupData().withName("test_name3").withHeader("test_surname").withFooter("test3"));
    }
  }

  @Test
  public void testGroupModification()
  {

    Set<GroupData> before = app.getGroupHelper().all();
    GroupData modifGroup = before.iterator().next();
    GroupData group = new GroupData().withName("test_name").withHeader("test_header").withFooter("test_footer");
    app.getGroupHelper().modifyGroup(group);
    Set<GroupData> after = app.getGroupHelper().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifGroup);
    before.add(group);
    Assert.assertEquals(before, after);

  }


}

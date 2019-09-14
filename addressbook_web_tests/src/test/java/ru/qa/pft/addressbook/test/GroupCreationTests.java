package ru.qa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.qa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupCreationTests extends BaseTest {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    Set<GroupData> before = app.getGroupHelper().all();
    GroupData group = new GroupData().withName("test_name3").withHeader("test_surname").withFooter("test3");
    app.getGroupHelper().creatorGroup(group);
    Set<GroupData> after = app.getGroupHelper().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    group.withId(after.stream().mapToInt(g->g.getId()).max().getAsInt());
    before.add(group);
    Assert.assertEquals(before, after);

  }

}

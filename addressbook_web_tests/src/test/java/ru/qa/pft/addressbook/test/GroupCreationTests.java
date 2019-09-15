package ru.qa.pft.addressbook.test;

import org.testng.annotations.*;
import ru.qa.pft.addressbook.model.GroupData;
import ru.qa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class GroupCreationTests extends BaseTest {

  @Test
  public void testGroupCreation() throws Exception {

    app.getNavigationHelper().gotoGroupPage();
    Groups before = app.getGroupHelper().all();
    GroupData group = new GroupData().withName("test2");
    app.getGroupHelper().creatorGroup(group);
    assertThat(app.getGroupHelper().count(), equalTo(before.size() + 1));
    Groups after = app.getGroupHelper().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo
            (before.withAdded(group.withId(after.stream().mapToInt(g -> g.getId()).max().getAsInt()))));
  }

  @Test
  public void testBadGroupCreation2() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    Groups before = app.getGroupHelper().all();
    GroupData group = new GroupData().withName("test2'");
    app.getGroupHelper().creatorGroup(group);
    assertThat(app.getGroupHelper().count(), equalTo(before.size()));
    Groups after = app.getGroupHelper().all();
    assertThat(after, equalTo(before));
  }

}

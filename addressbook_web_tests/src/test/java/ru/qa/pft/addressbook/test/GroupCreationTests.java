package ru.qa.pft.addressbook.test;

import org.testng.annotations.*;
import ru.qa.pft.addressbook.model.GroupData;
import ru.qa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class GroupCreationTests extends BaseTest {

  @Test
  public void testGroupCreation() throws Exception {

    app.goTo().gotoGroupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("test2");
    app.group().creatorGroup(group);
    assertThat(app.group().count(), equalTo(before.size() + 1));
    Groups after = app.group().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo
            (before.withAdded(group.withId(after.stream().mapToInt(g -> g.getId()).max().getAsInt()))));
  }

  @Test
  public void testBadGroupCreation2() throws Exception {
    app.goTo().gotoGroupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("test2'");
    app.group().creatorGroup(group);
    assertThat(app.group().count(), equalTo(before.size()));
    Groups after = app.group().all();
    assertThat(after, equalTo(before));
  }

}

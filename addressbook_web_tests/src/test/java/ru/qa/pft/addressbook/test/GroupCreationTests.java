package ru.qa.pft.addressbook.test;

import org.testng.annotations.*;
import ru.qa.pft.addressbook.model.GroupData;
import ru.qa.pft.addressbook.model.Groups;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class GroupCreationTests extends TestBase {
  @DataProvider
  public Iterator<Object[]> validGroup(){
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[] {new GroupData().withName("test1").withHeader("header1").withFooter("footer1")});
    list.add(new Object[] {new GroupData().withName("test1").withHeader("header1").withFooter("footer1")});
    list.add(new Object[] {new GroupData().withName("test1").withHeader("header1").withFooter("footer1")});
    return  list.iterator();
  }


  @Test(dataProvider = "validGroup")
  public void testGroupCreation(GroupData group)
  {
      app.goTo().gotoGroupPage();
      Groups before = app.group().all();
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

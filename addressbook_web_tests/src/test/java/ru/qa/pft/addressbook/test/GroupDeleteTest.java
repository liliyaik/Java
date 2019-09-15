package ru.qa.pft.addressbook.test;

import org.testng.annotations.*;
import ru.qa.pft.addressbook.model.GroupData;
import ru.qa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.assertEquals;

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

      Groups before = app.getGroupHelper().all();
      GroupData deletedGroup = before.iterator().next();
      app.getGroupHelper().deleteGroup(deletedGroup);
      assertThat(app.getGroupHelper().count(), equalTo(before.size()-1));
      Groups after = app.getGroupHelper().all();
      assertThat(after, equalTo(before.without(deletedGroup)));
    }
  }





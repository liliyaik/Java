package ru.qa.pft.addressbook.test;

import org.testng.annotations.*;
import ru.qa.pft.addressbook.model.GroupData;
import ru.qa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.AssertJUnit.assertEquals;

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

    Groups before = app.getGroupHelper().all();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifiedGroup.getId()).withName("test111").withHeader("test222").withFooter("test333");

    app.getGroupHelper().modifyGroup(group);
    assertThat(app.getGroupHelper().count(), equalTo(before.size()));
    Groups after = app.getGroupHelper().all();
    assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));


  }


}
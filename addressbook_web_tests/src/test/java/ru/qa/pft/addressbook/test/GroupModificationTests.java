package ru.qa.pft.addressbook.test;

import org.testng.annotations.*;
import ru.qa.pft.addressbook.model.GroupData;
import ru.qa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.AssertJUnit.assertEquals;

public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition(){
    if(app.db().groups().size() == 0)
    {
    app.goTo().gotoGroupPage();
    app.group().creatorGroup(new GroupData().withName("test_name3").withHeader("test_surname").withFooter("test3"));}
  }

  @Test
  public void testGroupModification() {
    Groups before = app.db().groups();
    app.goTo().gotoGroupPage();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifiedGroup.getId()).withName("name_test").withHeader("header_test").withFooter("footer_test");

    app.group().modifyGroup(group);
    assertThat(app.group().count(), equalTo(before.size()));
    Groups after = app.db().groups();
    assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
    verifyGroupListInUi();
  }

}


package ru.qa.pft.addressbook.test;

import com.thoughtworks.xstream.XStream;
import org.testng.annotations.*;
import ru.qa.pft.addressbook.model.GroupData;
import ru.qa.pft.addressbook.model.Groups;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class GroupCreationTests extends TestBase {
  @DataProvider
  public Iterator<Object[]> validGroups() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.xml")));
    String xml = "";
    String line = reader.readLine();
    while (line != null){
      xml += line;
      line = reader.readLine();
    }
    XStream xstream = new XStream();
    xstream.processAnnotations(GroupData.class);
    List<GroupData> groups = (List<GroupData>) xstream.fromXML(xml);
    return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
  }

  @Test(dataProvider = "validGroups")
  public void testGroupCreation(GroupData group) throws Exception {
    app.goTo().gotoGroupPage();
    Groups before = app.group().all();
    app.group().creatorGroup(group);
    assertThat(app.group().count(), equalTo(before.size() + 1));
    Groups after = app.group().all();
    assertThat(after, equalTo
            (before.withAdded(group.withId(after.stream().mapToInt(g -> g.getId()).max().getAsInt()))));
  }

  @Test
  public void testBadGroupCreation() throws Exception {
    app.goTo().gotoGroupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("test2'");
    app.group().creatorGroup(group);
    assertThat(app.group().count(), equalTo(before.size()));
    Groups after = app.group().all();
    assertThat(after, equalTo(before));
  }
}
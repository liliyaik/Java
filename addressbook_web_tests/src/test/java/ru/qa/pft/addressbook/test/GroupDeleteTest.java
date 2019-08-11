package ru.qa.pft.addressbook.test;

import org.testng.annotations.*;
import org.openqa.selenium.*;

public class GroupDeleteTest extends BaseTest {

  @Test
  public void testGroupDelete() throws Exception {
    app.gotoGroupPage("groups");
    selectGroup("selected[]");
    DeleteSelectionGroup("delete");
    app.returmGroupPage("group page");
    app.logout("Logout");
  }

  public void DeleteSelectionGroup(String delete) {
    app.wd.findElement(By.name(delete)).click();
  }

  public void selectGroup(String s) {
    app.wd.findElement(By.name(s)).click();
  }
}

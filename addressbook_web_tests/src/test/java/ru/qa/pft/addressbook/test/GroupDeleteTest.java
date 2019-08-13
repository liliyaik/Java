package ru.qa.pft.addressbook.test;

import org.testng.annotations.*;
import org.openqa.selenium.*;

public class GroupDeleteTest extends BaseTest {

  @Test
  public void testGroupDelete() throws Exception {
    app.gotoGroupPage();
    selectGroup();
    DeleteSelectionGroup();
    app.getGroupHelper().returmGroupPage();
    app.logout();
  }

  public void DeleteSelectionGroup() {
    app.getGroupHelper().wd.findElement(By.name("delete")).click();
  }

  public void selectGroup() {
    app.getGroupHelper().wd.findElement(By.name("selected[]")).click();
  }
}

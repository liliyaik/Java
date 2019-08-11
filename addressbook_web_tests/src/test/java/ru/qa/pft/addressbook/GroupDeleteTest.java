package ru.qa.pft.addressbook;

import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;

public class GroupDeleteTest extends BaseTest {

  @Test
  public void testGroupDelete() throws Exception {
    gotoGroupPage("groups");
    selectGroup("selected[]");
    DeleteSelectionGroup("delete");
    returmGroupPage("group page");
    logout("Logout");
  }

  public void DeleteSelectionGroup(String delete) {
    wd.findElement(By.name(delete)).click();
  }

  public void selectGroup(String s) {
    wd.findElement(By.name(s)).click();
  }
}

package ru.qa.pft.addressbook;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GroupCreationTests extends BaseTest {

  @Test
  public void testGroupCreation() throws Exception {

    gotoGroupPage("groups");
    initGroupCreation("new");
    fillGroupForm(new GroupData("test1", "test2", "test3"));
    submitGrouCreation("submit");
    returmGroupPage("group page");
    logout("Logout");
  }

}

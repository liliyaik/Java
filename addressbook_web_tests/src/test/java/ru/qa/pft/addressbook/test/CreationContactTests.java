package ru.qa.pft.addressbook.test;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.qa.pft.addressbook.model.GroupDataContact;
import org.openqa.selenium.WebDriver;

public class CreationContactTests extends BaseTest {

  @Test
  public void testCreationContact() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    app.contactHelper.creatorNewContact(new GroupDataContact("LILIYA2", "IKSANOVA3", "limma4", "Moscow city", "limma@yandex2.ru", null),false);
    app.getNavigationHelper().gotoGroupPage();
    app.getNavigationHelper().gotoHomePage();
    app.logout();
  }

}

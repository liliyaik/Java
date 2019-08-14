package ru.qa.pft.addressbook.test;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.qa.pft.addressbook.model.GroupDataContact;

public class CreatedNewContact extends BaseTest {

  @Test
  public void testAddContact() throws Exception {
    app.contactHelper.gotoContactpage();
    app.contactHelper.fillDataForm(new GroupDataContact("LILIYA", "IKSANOVA", "limma", "Moscow", "limma@yandex.ru"));
    app.contactHelper.SubmitCreateContact();
    app.logout();
  }

}

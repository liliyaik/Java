package ru.qa.pft.addressbook.test;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.qa.pft.addressbook.model.GroupDataContact;

public class EditContact extends BaseTest {

  @Test
  public void testEditContact() throws Exception {
    app.contactHelper.gotoContactEdit();
    app.contactHelper.fillDataForm(new GroupDataContact("LILIYA2", "IKSANOVA3", "limma4", "Moscow city", "limma@yandex2.ru"));
    app.contactHelper.SubmitEditContact();
    app.logout();
  }

}

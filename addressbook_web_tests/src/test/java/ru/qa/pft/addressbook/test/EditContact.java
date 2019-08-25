package ru.qa.pft.addressbook.test;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.qa.pft.addressbook.model.GroupData;
import ru.qa.pft.addressbook.model.GroupDataContact;

public class EditContact extends BaseTest {

  @Test
  public void testEditContact() throws Exception {
    if (! app.contactHelper.isThereAGroup())
    {
      app.contactHelper.creatorNewContact(new GroupDataContact("LILIYA2", "IKSANOVA3", "limma4", "Moscow city", "limma@yandex2.ru", null),false);
      app.getNavigationHelper().gotoHomePage();
    }
    app.contactHelper.gotoContactEdit();
    app.contactHelper.fillDataForm(new GroupDataContact("LILIYA2", "IKSANOVA3", "limma4", "Moscow city", "limma@yandex2.ru", null),false);
    app.contactHelper.SubmitEditContact();
    app.logout();
  }

}

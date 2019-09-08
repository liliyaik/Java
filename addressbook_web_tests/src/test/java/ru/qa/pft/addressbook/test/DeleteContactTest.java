package ru.qa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.qa.pft.addressbook.model.GroupData;
import ru.qa.pft.addressbook.model.GroupDataContact;
import org.testng.annotations.Test;
import ru.qa.pft.addressbook.model.GroupDataContact;

import java.util.List;

public class DeleteContactTest extends BaseTest {

    @Test(enabled = false)
    public void testDeleteContact() throws Exception {
      if (! app.contactHelper.isThereAGroup())
      {
        app.contactHelper.creatorNewContact(new GroupDataContact(0,"LILIYA2", "IKSANOVA3", "limma4", "Moscow city", "limma@yandex2.ru", null));
        app.getNavigationHelper().gotoHomePage();
      }

      List<GroupDataContact> before = app.getContactHelper().getContactList();
      app.getContactHelper().selectContact(before.size() - 1);
      app.getContactHelper().DeleteSelectionContact();
      List<GroupDataContact> after = app.getContactHelper().getContactList();
      Assert.assertEquals(after.size(), before.size() - 1);

      before.remove(before.size() - 1);
      Assert.assertEquals(before, after);
    }

  }


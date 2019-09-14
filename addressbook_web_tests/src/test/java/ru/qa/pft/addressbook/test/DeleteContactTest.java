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
import java.util.Set;

public class DeleteContactTest extends BaseTest {

    @Test(enabled = true)
    public void testDeleteContact() throws Exception {
      if (! app.contactHelper.isThereAGroup())
      {
        app.contactHelper.creatorNewContact(new GroupDataContact().withId(0).withName("name").withFio("Iksanova").withNik("limma").withCity("Moscow").withEmail("limma@yandex.ru"));
        app.getNavigationHelper().gotoHomePage();
      }

      Set<GroupDataContact> before = app.getContactHelper().all();
      app.getContactHelper().selectContact(before.size() - 1);
      app.getContactHelper().DeleteSelectionContact();
      Set<GroupDataContact> after = app.getContactHelper().all();
      Assert.assertEquals(after.size(), before.size() - 1);

      before.remove(before.size() - 1);
      Assert.assertEquals(before, after);
    }

  }


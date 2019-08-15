package ru.qa.pft.addressbook.test;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.qa.pft.addressbook.model.GroupDataContact;
import org.testng.annotations.Test;
import ru.qa.pft.addressbook.model.GroupDataContact;

public class DeleteContactTest extends BaseTest {

    @Test
    public void testDeleteContact() throws Exception {
      app.contactHelper.gotoContactEdit();
      app.contactHelper.SubmitDeleteContact();
      app.logout();
    }

  }


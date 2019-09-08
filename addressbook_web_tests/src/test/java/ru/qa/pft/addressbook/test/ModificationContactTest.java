package ru.qa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.qa.pft.addressbook.model.GroupData;
import ru.qa.pft.addressbook.model.GroupDataContact;

import java.util.Comparator;
import java.util.List;

public class ModificationContactTest extends BaseTest {

  @Test
  public void testModificationContact() throws Exception {
    if (! app.contactHelper.isThereAGroup())
    {
      app.contactHelper.creatorNewContact(new GroupDataContact(0,"LILIYA2", "IKSANOVA3", "limma4", "Moscow city", "limma@yandex2.ru", null));
      app.getNavigationHelper().gotoHomePage();
    }

    List<GroupDataContact> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().initContactModification();
    GroupDataContact contact = new GroupDataContact(before.get(before.size()-1).getId(), "LILIYA4", "IKSANOVA4", "limma4", "Moscow city", "limma@yandex2.ru", null);
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnContactPage();
    List<GroupDataContact> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());


    before.remove(before.size() - 1);
    before.add(contact);
    Comparator<? super GroupDataContact> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId()) ;
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}

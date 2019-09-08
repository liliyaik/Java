//package ru.qa.pft.addressbook.test;
//
//import org.testng.Assert;
//import org.testng.annotations.*;
//import org.openqa.selenium.*;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import ru.qa.pft.addressbook.model.GroupData;
//import ru.qa.pft.addressbook.model.GroupDataContact;
//
//import java.util.Comparator;
//import java.util.List;
//
//public class ModificationContactTest extends BaseTest {
//
//  @Test
//  public void testModificationContact() throws Exception {
//    if (! app.contactHelper.isThereAGroup())
//    {
//      app.contactHelper.creatorNewContact(new GroupDataContact("LILIYA2", "IKSANOVA3", "limma4", "Moscow city", "limma@yandex2.ru", null),false);
//      app.getNavigationHelper().gotoHomePage();
//    }
//
//    List<GroupDataContact> before = app.getContactHelper().getContactList();
//    app.getContactHelper().selectContact(before.size() - 1);
//    app.getGroupHelper().initGroupModification();
//    GroupData group = new GroupData(before.get(before.size()-1).getId(), "test1", "test2", "test3", null);
//    app.getContactHelper().fillContactForm(group);
//    app.getContactHelper().submitContactModification();
//    app.getContactHelper().returmContactPage();
//    List<GroupDataContact> after = app.getContactHelper().getContactList();
//    Assert.assertEquals(after.size(), before.size());
//
//
//    before.remove(before.size() - 1);
//    before.add(group);
//    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId()) ;
//    before.sort(byId);
//    after.sort(byId);
//    Assert.assertEquals(before, after);
//  }
//
//}

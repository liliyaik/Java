//package ru.qa.pft.addressbook.test;
//
//import org.testng.Assert;
//import org.testng.annotations.*;
//import org.openqa.selenium.*;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import ru.qa.pft.addressbook.model.GroupData;
//import ru.qa.pft.addressbook.model.GroupDataContact;
//import org.openqa.selenium.WebDriver;
//
//import java.util.Comparator;
//import java.util.List;
//
//public class CreationContactTests extends BaseTest {
//
//  @Test(enabled = false)
//  public void testCreationContact() throws Exception {
//    app.getNavigationHelper().gotoContactPage();
//    List<GroupDataContact> before = app.getContactHelper().getContactList();
//    GroupDataContact contact = new GroupDataContact(0, "LILIYA2", "IKSANOVA3", "limma4", "Moscow city", "limma@yandex2.ru", null);
//    app.contactHelper.creatorNewContact(contact);
//    app.getNavigationHelper().gotoHomePage();
//    List<GroupDataContact> after = app.getContactHelper().getContactList();
//    Assert.assertEquals(after.size(), before.size() + 1);
//
//    contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
//    before.add(contact);
//    Comparator<? super GroupDataContact> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId()) ;
//    before.sort(byId);
//    after.sort(byId);
//    Assert.assertEquals(before, after);
//
//
//  }
//
//}

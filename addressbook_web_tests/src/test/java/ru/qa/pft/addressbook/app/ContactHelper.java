package ru.qa.pft.addressbook.app;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.qa.pft.addressbook.model.Contacts;
import ru.qa.pft.addressbook.model.GroupData;
import ru.qa.pft.addressbook.model.GroupDataContact;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends BaseHelper {
  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void gotoContactpage() {
    click(By.linkText("add new"));
  }

  public void gotoContactEdit() {
    click(By.xpath("(//img[@alt='Edit'])[1]"));
  }

  public void logout() {
    click(By.linkText("Logout"));
  }

  public void SubmitCreateContact() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void SubmitEditContact() {
    click(By.xpath("(//input[@name='update'])[2]"));
  }

  public void SubmitDeleteContact() {
    click(By.xpath("(//input[@name='update'])[3]"));
  }

  public void Login(String username, String password) {
    wd.get("http://localhost/addressbook/");
    type(By.name("user"), username);
    type(By.name("pass"), password);
    wd.findElement(By.id("LoginForm")).submit();
  }

  public void fillDataForm(GroupDataContact groupDataContact, boolean creator) {
    type(By.name("firstname"), groupDataContact.getName());
    type(By.name("middlename"), groupDataContact.getFio());
    type(By.name("nickname"), groupDataContact.getNik());
    type(By.name("address"), groupDataContact.getCity());
    type(By.name("email"), groupDataContact.getEmail());

//    if (creator)
//    {
//      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(groupDataContact.getGroup());
//    }
//    else {
//      Assert.assertFalse(isElementPresent (By.name("new_group")));
//    }

    }

  public void creatorNewContact(GroupDataContact groupDataContact) {
    gotoContactpage();
    fillDataForm(groupDataContact,true);
    SubmitCreateContact();
  }
  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }

  public List<GroupDataContact> getContactList() {
    List<GroupDataContact> groups = new ArrayList<GroupDataContact>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      //String name = element.getText();
      String name = cells.get(1).getText();
      String lastname = cells.get(2).getText();
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      //int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      GroupDataContact contact = new GroupDataContact().withId(id).withName(name).withFio(lastname);
      groups.add(contact);
    }
    return groups;

  }
  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> elements = wd.findElements(By.cssSelector("tr[name='entry']"));
    for (WebElement element : elements){
      List<WebElement> cells = element.findElements(By.cssSelector("td"));
      String firstname = cells.get(2).getText();
      String lastname = cells.get(1).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new GroupDataContact().withId(id).withName(firstname).withName(lastname));
    }
    return contacts;
  }


  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void DeleteSelectionContact() {
    click(By.xpath("//input[@value='Delete']"));
    Alert alert = wd.switchTo().alert();
    alert.accept();
  }
  public void delete(GroupDataContact contact) {
    selectContactById(contact.getId());
    DeleteSelectionContact();
    returnContactPage();
  }
  public void returnContactPage() {
    if (isElementPresent(By.id("maintable"))){
      return;
    }
    click(By.linkText("home"));
  }

  public void initContactModification(int index) {
    click(By.xpath("//a[@href='edit.php?id=" + index + "']"));
  }
  public void modify(Set<GroupDataContact> before, GroupDataContact contact) {
    returnContactPage();
    initContactModification(contact.getId());
    fillContactForm(contact, false);
    submitContactModification();
    returnContactPage();
  }

  private void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void fillContactForm(GroupDataContact groupData, boolean creation) {
    type(By.name("firstname"), groupData.getName());
    type(By.name("lastname"), groupData.getName());
    type(By.name("nickname"), groupData.getName());
    type(By.name("address"), groupData.getName());
    type(By.name("email"), groupData.getName());

  }
  public void submitContactModification() {
    click(By.name("update"));
  }

}


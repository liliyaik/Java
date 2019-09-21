package ru.qa.pft.addressbook.app;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.qa.pft.addressbook.model.Contacts;
import ru.qa.pft.addressbook.model.ContactData;

import java.util.List;
import java.util.Set;

public class ContactHelper extends BaseHelper {
  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void gotoContactpage() {
    click(By.linkText("add new"));
  }
  public void gotoHomepage() {
    click(By.linkText("home"));
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

  public void fillDataForm(ContactData contactData, boolean creator) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("address"), contactData.getAddress());
    type(By.name("email"), contactData.getFirstemail());

//    if (creator)
//    {
//      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
//    }
//    else {
//      Assert.assertFalse(isElementPresent (By.name("new_group")));
//    }

    }

  public void creatorNewContact(ContactData contactData) {
    gotoContactpage();
    fillDataForm(contactData,true);
    SubmitCreateContact();
    gotoHomepage();
  }
  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }


  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> elements = wd.findElements(By.cssSelector("tr[name='entry']"));
    for (WebElement element : elements){
      List<WebElement> cells = element.findElements(By.cssSelector("td"));
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String firstname = cells.get(2).getText();
      String lastname = cells.get(1).getText();
      String address = cells.get(3).getText();
      String allPhones = cells.get(5).getText();
      String allEmails = cells.get(4).getText();
      contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname)
              .withAddress(address).withAllPhones(allPhones).withallemails(allEmails));
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
  public void delete(ContactData contact) {
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

  public void initContactModification(int id) {
    click(By.xpath("//a[@href='edit.php?id=" + id + "']"));
  }
  public void modify(Set<ContactData> before, ContactData contact) {
    returnContactPage();
    initContactModification(contact.getId());
    fillContactForm(contact, false);
    submitContactModification();
    returnContactPage();
  }

  private void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void fillContactForm(ContactData contactDate, boolean creation) {
    type(By.name("firstname"), contactDate.getFirstname());
    type(By.name("lastname"), contactDate.getLastname());
    type(By.name("nickname"), contactDate.getNickname());
    type(By.name("address"), contactDate.getAddress());
    type(By.name("email"), contactDate.getFirstemail());
    type(By.name("photo"), contactDate.getPhoto().getAbsolutePath());

  }
  public void submitContactModification() {
    click(By.name("update"));
  }

  public void initContactModificationById(int index) {
    click(By.xpath("//a[@href='edit.php?id=" + index + "']"));
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String firstmail = wd.findElement(By.name("email")).getAttribute("value");
    String secondmail = wd.findElement(By.name("email2")).getAttribute("value");
    String thirdmail = wd.findElement(By.name("email3")).getAttribute("value");

    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
            .withAddress(address)
            .withHomephone(home).withMobilephone(mobile).withWorkphone(work)
            .withFirstemail(firstmail).withSecondemail(secondmail).withThirdemail(thirdmail);
  }
}


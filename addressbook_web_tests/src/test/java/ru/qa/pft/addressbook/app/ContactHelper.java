package ru.qa.pft.addressbook.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.qa.pft.addressbook.model.GroupDataContact;

public class ContactHelper extends BaseHelper {
  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void gotoContactpage() {
    click(By.linkText("add new"));
  }

  public void gotoContactEdit() {
    click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='limma@yandex.ru'])[1]/following::img[2]"));
  }

  public void logout() {
    click(By.linkText("Logout"));
  }

  public void SubmitCreateContact() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void SubmitEditContact() {
    click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Notes:'])[1]/following::input[1]"));
  }

  public void SubmitDeleteContact() {
    click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Notes:'])[1]/following::input[3]"));
  }

  public void Login(String username, String password) {
    wd.get("http://localhost/addressbook/");
    type(By.name("user"), username);
    type(By.name("pass"), password);
    wd.findElement(By.id("LoginForm")).submit();
  }

  public void fillDataForm(GroupDataContact groupDataContact) {
    type(By.name("firstname"), groupDataContact.getName());
    type(By.name("middlename"), groupDataContact.getFio());
    type(By.name("nickname"), groupDataContact.getNik());
    type(By.name("address"), groupDataContact.getCity());
    type(By.name("email"), groupDataContact.getEmail());
  }
}

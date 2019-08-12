package ru.qa.pft.addressbook.test;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreatedNewContact {
  private WebDriver wd;

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    login("admin", "secret");
  }

  private void login(String name, String password) {
    wd.get("http://localhost/addressbook/group.php");
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(name);
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys( password);
    wd.findElement(By.id("LoginForm")).submit();
  }

  @Test
  public void testAddContact() throws Exception {
    gotoContactpage();
    fillDataForm(new GroupDataContact("LILIYA", "IKSANOVA", "limma", "Moscow", "limma@yandex.ru"));
    SubmitCreateContact();
    logout();
  }

  private void logout() {
    wd.findElement(By.linkText("Logout")).click();
  }

  public void SubmitCreateContact() {
    wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
  }

  public void fillDataForm(GroupDataContact groupDataContact) {
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(groupDataContact.getName());
    wd.findElement(By.name("middlename")).click();
    wd.findElement(By.name("middlename")).clear();
    wd.findElement(By.name("middlename")).sendKeys(groupDataContact.getFio());
    wd.findElement(By.name("nickname")).click();
    wd.findElement(By.name("nickname")).clear();
    wd.findElement(By.name("nickname")).sendKeys(groupDataContact.getNik());
    wd.findElement(By.name("address")).click();
    wd.findElement(By.name("address")).clear();
    wd.findElement(By.name("address")).sendKeys(groupDataContact.getCity());
    wd.findElement(By.name("mobile")).click();
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys(groupDataContact.getEmail());
  }

  public void gotoContactpage() {
    wd.findElement(By.linkText("add new")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    wd.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}

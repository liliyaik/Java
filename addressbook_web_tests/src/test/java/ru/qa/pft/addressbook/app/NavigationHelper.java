package ru.qa.pft.addressbook.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.security.acl.Group;

public class NavigationHelper extends BaseHelper {


  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  /***
   * Переход на страницу групп пейдж
   *
   */
  public void gotoGroupPage() {
    if (isElementPresent(By.tagName("h1"))
      && wd.findElement(By.tagName("h1")).getText().equals("Groups")
      && isElementPresent(By.name("new")))
    {
      return;
    }
    click(By.linkText("groups"));
  }

  public void gotoHomePage() {
    if (isElementPresent(By.id("maintable")))
    {
      return;
    }
    click(By.linkText("home"));
  }
}

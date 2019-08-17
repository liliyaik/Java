package ru.qa.pft.addressbook.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends BaseHelper {


  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  /***
   * Переход на страницу групп пейдж
   *
   */
  public void gotoGroupPage() {
    click(By.linkText("groups"));
  }
}

package ru.qa.pft.addressbook.app;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper {


  private FirefoxDriver wd;

  public NavigationHelper(FirefoxDriver wd) {
    this.wd = wd;
  }

  /***
   * Переход на страницу групп пейдж
   *
   */
  public void gotoGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }
}

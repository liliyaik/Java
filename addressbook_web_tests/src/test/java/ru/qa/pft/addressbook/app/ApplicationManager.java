package ru.qa.pft.addressbook.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;


import java.util.concurrent.TimeUnit;

public class ApplicationManager {

  private final String browser;
  WebDriver wd;

  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;
  private SessionHelper sessionHelper;
  public ContactHelper contactHelper;

  public ApplicationManager (String browser)
  {
    this.browser = browser;
  }

  public void init() {
//    String browser = BrowserType.FIREFOX();
    if (browser.equals(BrowserType.FIREFOX))
    {
      wd = new FirefoxDriver();
    }
    else if (browser.equals(BrowserType.CHROME))
    {
      wd = new ChromeDriver();
    }
    else if (browser.equals(BrowserType.IE))
    {
      wd = new InternetExplorerDriver();
    }

    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    contactHelper = new ContactHelper(wd);
    contactHelper.Login("admin", "secret");
  }

  public void logout() {
    wd.findElement(By.linkText("Logout")).click();
  }

  public void stop() {
    wd.quit();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public void gotoGroupPage() {
    navigationHelper.gotoGroupPage();
  }
}

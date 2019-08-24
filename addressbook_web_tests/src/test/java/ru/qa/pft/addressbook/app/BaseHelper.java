package ru.qa.pft.addressbook.app;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.NoSuchElementException;

public class BaseHelper {

  public WebDriver wd;

  public BaseHelper(WebDriver wd) {
    this.wd = wd;
  }

  public void click(By locator) {
    wd.findElement(locator).click();
  }

  protected void type(By locator, String text) {
    if (text != null) {
    click(locator);
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);}
  }


  public boolean isAlertPresent(){
  try
  {
    wd.switchTo().alert();
    return true;
  }
  catch (NoAlertPresentException e)
    {
      return false;
    }
    }

  protected boolean isElementPresent(By locator) {
    try {
      wd.findElement(locator);
      return true;
    } catch (Exception ex){
      return false;
    }

  }
}


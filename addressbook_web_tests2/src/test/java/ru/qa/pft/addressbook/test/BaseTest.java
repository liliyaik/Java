package ru.qa.pft.addressbook.test;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.qa.pft.addressbook.app.ApplicationManager;

public class BaseTest {

  public static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite
  public void tearDown() {
    app.stop();
  }
}
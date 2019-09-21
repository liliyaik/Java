package ru.qa.pft.addressbook.test;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.qa.pft.addressbook.app.ApplicationManager;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {
  Logger logger = LoggerFactory.getLogger(TestBase.class);

  public static final ApplicationManager app =
          //new ApplicationManager(BrowserType.CHROME);
          new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite
  public void tearDown() {
    app.stop();
  }

  @BeforeMethod
  public void logTestStart(Method m){
    logger.info("Start test " + m.getName());
  }

  @AfterMethod
  public void logTestStop(Method m, Object[] p){
    logger.info("Stop test " + m.getName() + " with parameters" + Arrays.asList(p));
  }

}

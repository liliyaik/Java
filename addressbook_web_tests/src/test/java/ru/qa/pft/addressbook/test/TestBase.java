package ru.qa.pft.addressbook.test;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.qa.pft.addressbook.app.ApplicationManager;
import ru.qa.pft.addressbook.model.GroupData;
import ru.qa.pft.addressbook.model.Groups;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

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

  public void verifyGroupListInUi() {
    if(Boolean.getBoolean("verifyUi")) {
      Groups dbGroups = app.db().groups();
      Groups uiGroups = app.group().all();
      assertThat(uiGroups, equalTo(dbGroups.stream().map((g) -> new GroupData().
              withId(g.getId()).withName(g.getName())).collect(Collectors.toSet())));
    }
  }

}

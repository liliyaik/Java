package ru.stqa.pft.mantis.test;

import appmanager.HelperBase;
import org.testng.annotations.Test;

public class RegistrationHelper extends TestBase {
  @Test
  public void testRegistration(){
    app.registration().start("user1", "test@test.ru");

  }
}

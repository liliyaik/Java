package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.appmanager.HttpSession;
import ru.stqa.pft.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ResetPasswordUser extends TestBase{
  public void startMailServer(){
    app.mail().start();
  }

  @Test
  public void testResetPasswordUser() throws IOException, MessagingException {
    String username = "user1";
    String email = "user1@localhost";
    String password = "password";
    String newpassword = "newpassword";
    String adminname = app.getProperty("web.adminLogin");
    String adminpwd = app.getProperty("web.adminPassword");
    HttpSession session = app.newSession();
    app.usersadmin().loginAsAnybody(adminname, adminpwd);
    app.usersadmin().gotoUsersAdministration();
    app.usersadmin().selectUser(username);
    app.james().doesUserExist(username);
    app.usersadmin().resetPassword();
    app.usersadmin().logout();
    List<MailMessage> mailMessages = app.james().waitForMail(username, password, 60000);
    String confirmationLink = findConfirmationLink(mailMessages, email);
    System.out.println(confirmationLink);
    app.usersadmin().finishPwdReset(confirmationLink, newpassword, username);
    app.usersadmin().loginAsAnybody(username, newpassword);
    assertTrue(session.isLoggedInAs(username));
  }

  private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex()
            .find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }

    @AfterMethod(alwaysRun = true)
  public void stopMailServer(){
    app.mail().stop();
  }
}

package ru.stqa.pft.rest.tests;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class RestTests extends TestBase {


  @Test(enabled = true)
  public void testCreateIssue() throws IOException {

    int isId = 50;
    Set<Issue> oldIssues = getIssues();
    Issue newIssue = new Issue().withSubject("Test issue lil").withDescription("New test issue");
    int issueId = createIssue(newIssue);
    System.out.println("Created issue " + issueId);
    Set<Issue> newIssues = getIssues();
    oldIssues.add(newIssue.withId(issueId));
    assertEquals(newIssues, oldIssues);
  }

}

package ru.stqa.pft.rest.tests;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.protobuf.ServiceException;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicNameValuePair;
import org.testng.SkipException;

import java.io.IOException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Set;

public class TestBase {


  //boolean isIssueOpen(int issueId) throws IOException {
  //  Set<Issue> oldIssues = getIssues();
  //  int issueState = oldIssues.iterator().next().withId(issueId).getState();
  //  if (issueState == 2) return false;
  //  else return true;
  //}

  public Set<Issue> getIssues() throws IOException {
    String json = getExecutor().execute(Request.Get("https://bugify.stqa.ru/api/issues.json?limit=500"))
            .returnContent().asString();
    JsonElement parsed = new JsonParser().parse(json);
    System.out.println(parsed);
    JsonElement issues = parsed.getAsJsonObject().get("issues");
    System.out.println(issues);
    return new Gson().fromJson(issues, new TypeToken<Set<Issue>>(){}.getType());
  }

  public Executor getExecutor() {
    return  Executor.newInstance().auth("288f44776e7bec4bf44fdfeb1e646490","");
  }

  public int createIssue(Issue newIssue) throws IOException {

    String json = getExecutor().execute(Request.Post("https://bugify.stqa.ru/api/issues.json?limit=500").
            bodyForm(new BasicNameValuePair("subject", newIssue.getSubject()),
                    new BasicNameValuePair("description", newIssue.getDescription())))
            .returnContent().asString();

    JsonElement parsed = new JsonParser().parse(json);
    return parsed.getAsJsonObject().get("issue_id").getAsInt();

  }

  public void skipIfNotFixed(int issueId) throws IOException {
    if (isIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }
 public boolean isIssueOpen(int issueId) throws IOException {
   String uri = String.format("https://bugify.stqa.ru/api/issues/%d.json?limit=500", issueId);
    String json = getExecutor().execute(Request.Get(uri))
           .returnContent().asString();
    JsonObject parsed = (JsonObject) new JsonParser().parse(json);
    String state = parsed.getAsJsonArray("issues").get(0).getAsJsonObject().get("state_name").getAsString();
   if(state.equals("Open")){
     return true;
   }
  return false;
  }

}

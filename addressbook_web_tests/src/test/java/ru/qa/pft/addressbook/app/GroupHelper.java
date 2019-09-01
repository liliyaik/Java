package ru.qa.pft.addressbook.app;

import org.omg.CORBA.ValueBaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import ru.qa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class GroupHelper<group> extends BaseHelper {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void init() {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    Login("admin", "secret");
  }

  private void Login(String username, String password) {
    wd.get("http://localhost/addressbook/");
    type(By.name("user"), username);
    type(By.name("pass"), password);
    wd.findElement(By.id("LoginForm")).submit();
  }

  public void returmGroupPage() {
    click(By.linkText("group page"));
  }

  public void submitGrouCreation() {
    click(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getName());
    type(By.name("group_footer"), groupData.getName());

  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void DeleteSelectionGroup() {
    click(By.name("delete"));
  }

  public void selectGroup(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void initGroupModification() {
    click(By.name("edit"));

  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public void creatorGroup(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGrouCreation();
    returmGroupPage();
  }

  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getGroupSize() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<GroupData> getGroupList() {
    List<GroupData> groups = new ArrayList<GroupData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      GroupData group = new GroupData(name, null, null, null);
      groups.add(group);
    }
    return groups;

  }
}

package ru.qa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.qa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneEmailTests extends TestBase {

  @Test
  public void ContactPhoneEmailTests(){
    app.contact().returnContactPage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAddress(), equalTo(address(contactInfoFromEditForm)));
    //assertThat(contact.getAllemails(), equalTo(mergeEmails(contactInfoFromEditForm)));
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
  }

  private String address(ContactData contactInfoFromEditForm) {
    return contactInfoFromEditForm.getAddress();
  }

  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getFirstemail(), contact.getSecondemail(), contact.getThirdemail())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactPhoneEmailTests::cleanedemail)
            .collect(Collectors.joining("\n"));
  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHomephone(), contact.getMobilephone(), contact.getWorkphone())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleanedemail(String email){
    return email.replaceAll("\\s", "").replaceAll("[-()]", "");
  }

  public static String cleanedphone(String phone){
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}


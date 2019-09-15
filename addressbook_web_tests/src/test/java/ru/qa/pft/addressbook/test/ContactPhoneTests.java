package ru.qa.pft.addressbook.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.qa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactPhoneTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();
    if(app.contact().all().size() == 0){
      app.contact().creatorNewContact (new ContactData().
              withFirstname("name").withLastname("Iksanova").withNickname("limma").withAddress("Moscow").
              withEmails("limma@yandex.ru").withFirstemail("limma2@yandex.ru").withSecondemail("limma3@ya.ru").
              withMobilephone("79851141541").withHomephone("222222222"));
    }
  }
    @Test
    public void testContactPhones(){
      app.contact().returnContactPage();
      ContactData contact = app.contact().all().iterator().next();
      ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

      assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    }

    private String mergePhones(ContactData contact) {
      return Arrays.asList(contact.getHomephone(), contact.getMobilephone(), contact.getWorkphone())
              .stream().filter((s) -> ! s.equals(""))
              .map(ContactPhoneTests::cleaned)
              .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String phone){
      return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }
  }

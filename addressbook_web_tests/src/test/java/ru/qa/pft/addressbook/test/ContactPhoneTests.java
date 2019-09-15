//package ru.qa.pft.addressbook.test;
//
//import org.testng.annotations.Test;
//import ru.qa.pft.addressbook.app.BaseHelper;
//import ru.qa.pft.addressbook.model.ContactData;
//
//import java.util.Arrays;
//import java.util.stream.Collectors;
//
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.hamcrest.MatcherAssert.assertThat;
//import static ru.qa.pft.addressbook.test.BaseTest.app;
//
//
//public class ContactPhoneTests extends BaseHelper {
//
//  @Test
//  public void testContactPhones(){
//    app.contact().returnContactPage();
//    ContactData contact = app.contact().all().iterator().next();
//    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
//
//    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
//  }
//
//  private String mergePhones(ContactData contact) {
//    return Arrays.asList(contact.getHomephone(), contact.getMobilephone(), contact.getWorkphone())
//            .stream().filter((s) -> ! s.equals(""))
//            .map(ContactPhoneTests::cleaned)
//            .collect(Collectors.joining("\n"));
//  }
//
//  public static String cleaned(String phone){
//    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
//  }
//}
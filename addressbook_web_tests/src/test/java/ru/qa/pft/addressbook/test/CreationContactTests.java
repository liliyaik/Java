package ru.qa.pft.addressbook.test;

import com.thoughtworks.xstream.XStream;
import org.testng.annotations.*;
import ru.qa.pft.addressbook.model.ContactData;
import ru.qa.pft.addressbook.model.Contacts;
import ru.qa.pft.addressbook.model.GroupData;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreationContactTests extends TestBase {
  @DataProvider
  public Iterator<Object[]> validGroups() throws IOException {
    BufferedReader reader = new BufferedReader (new FileReader(new File("src/test/resources/contacts.xml")));
    String xml = "";
    String line = reader.readLine();
    while (line != null) {
      xml += line;
      line = reader.readLine();
    }
    XStream xstream = new XStream();
    xstream.processAnnotations(ContactData.class);
    List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
    return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
  }

  @Test(enabled = true)
  public void testCreationContact() throws Exception {

    File photo = new File("src/test/resources/imgcat.jpg");
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("Liliya").withLastname("Iksanova").withNickname("limma").withCompany("company").withAddress("Moscow").withMobilephone("9778046498").withPhoto(photo);
    app.contact().creatorNewContact(contact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));

   assertThat(after, equalTo
            (before.withAdded(contact.withId(after.stream().mapToInt(g -> g.getId()).max().getAsInt()))));
  }



}


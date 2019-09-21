package ru.qa.pft.addressbook.generator;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.thoughtworks.xstream.XStream;
import ru.qa.pft.addressbook.model.ContactData;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

  @Parameter(names = "-c", description = "Group count")
  public int count;

  @Parameter (names = "-f", description = "Target file")
  public String file;

  @Parameter (names = "-d", description = "Data format")
  public String format;

  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    }
    catch (ParameterException e) {
      jCommander.usage();
      return;
    }
    generator.run();
  }

  private void run() throws IOException {
    List<ContactData> contact = generateContact(count);
    if (format.equals("csv")) {
      saveAsCsv(contact, new File(file));
    } else if (format.equals("xml")){
      saveAsXml(contact, new File(file));
    } else {
      System.out.println("Unrecognized format " + format);
    }

  }

  private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.processAnnotations(ContactData.class);
    String xml = xstream.toXML(contacts);
    Writer writer = new FileWriter(file);
    writer.write(xml);
    writer.close();
  }

  private List<ContactData> generateContact(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactData().
              withFirstname(String.format("Firstname %s", i)).
              withLastname(String.format("Lastname %s", i)).
              withNickname(String.format("Nickname %s", i)));
    }
    return contacts;
  }

  private void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
    Writer writer = new FileWriter(file);
    for (ContactData contact: contacts) {
      writer.write(String.format("%s;%s;%s\n", contact.getFirstname(), contact.getLastname(), contact.getNickname(), contact.getCompany(),
              contact.getAddress(), contact.getMobilephone()));
    }
    writer.close();

  }
}
package ru.qa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;
import java.util.HashSet;
import java.util.Set;

public class Contacts extends ForwardingSet<GroupDataContact> {
  private Set<GroupDataContact> delegate;

  public Contacts(Contacts contacts) {
    this.delegate = new HashSet<GroupDataContact>(contacts.delegate);
  }

  public Contacts() {
    this.delegate = new HashSet<GroupDataContact>();
  }

  @Override
  protected Set<GroupDataContact> delegate() {
    return this.delegate;
  }

  public Contacts withAdded(GroupDataContact contact){
    Contacts contacts = new Contacts(this);
    contacts.add(contact);
    return contacts;
  }

  public Contacts without(GroupDataContact contact){
    Contacts contacts = new Contacts(this);
    contacts.remove(contact);
    return contacts;
  }
}

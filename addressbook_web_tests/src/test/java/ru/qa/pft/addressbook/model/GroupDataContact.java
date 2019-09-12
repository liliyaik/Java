package ru.qa.pft.addressbook.model;

import java.util.Objects;

public class GroupDataContact {
  public int id;
  private final String name;
  private final String fio;
  private final String nik;
  private final String city;
  private final String email;
  private String group;


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupDataContact that = (GroupDataContact) o;
    return Objects.equals(name, that.name) && Objects.equals(fio, that.fio);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  public GroupDataContact(int id, String name, String fio, String nik, String city, String email, String group) {
    this.id =  Integer.MAX_VALUE;
    this.name = name;
    this.fio = fio;
    this.nik = nik;
    this.city = city;
    this.email = email;
    this.group = group;
  }

  public String getName() {
    return name;
  }

  public String getFio() {
    return fio;
  }

  public String getNik() {
    return nik;
  }

  public String getCity() {
    return city;
  }

  public String getEmail() {
    return email;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "GroupDataContact{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
  }



  public int getId() {
    return id;
  }
}

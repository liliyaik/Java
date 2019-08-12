package ru.qa.pft.addressbook.test;

public class GroupDataContact {
  private final String name;
  private final String fio;
  private final String nik;
  private final String city;
  private final String email;

  public GroupDataContact(String name, String fio, String nik, String city, String email) {
    this.name = name;
    this.fio = fio;
    this.nik = nik;
    this.city = city;
    this.email = email;
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
}

package ru.qa.pft.addressbook.model;

import java.util.Objects;

public class GroupDataContact {
  public int id = Integer.MAX_VALUE;
  private String name;
  private String fio;
  private String nik;
  private String city;
  private String email;
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

  public GroupDataContact withId(int id) {
    this.id = id;
    return this;
  }

  public GroupDataContact withName(String name) {
    this.name = name;
    return this;
  }

  public GroupDataContact withFio(String fio) {
    this.fio = fio;
    return this;
  }

  public GroupDataContact withNik(String nik) {
    this.nik = nik;
    return this;
  }

  public GroupDataContact withCity(String city) {
    this.city = city;
    return this;
  }

  public GroupDataContact withEmail(String email) {
    this.email = email;
    return this;
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

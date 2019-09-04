package ru.qa.pft.addressbook.model;

import java.util.Objects;

public class GroupData {
  public int id;
  private final String name;
  private final String header;
  private final String footer;
  private String group;


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupData groupData = (GroupData) o;
    return Objects.equals(name, groupData.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  public GroupData(String name, String header, String footer, String group) {

    this.id = Integer.MAX_VALUE;
    this.name = name;
    this.header = header;
    this.footer = footer;
    this.group = group;
  }

  public GroupData(int id, String name, String header, String footer, String group) {

    this.id = id;
    this.name = name;
    this.header = header;
    this.footer = footer;
    this.group = group;
  }

  public String getName() {
    return name;
  }

  public String getHeader() {
    return header;
  }

  public int getId() {
    return id;
  }

  public String getFooter() {
    return footer;
  }

  public String getGroup() {
    return group;
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
  }

  public void setId(int id) {
    this.id = id;
  }
}

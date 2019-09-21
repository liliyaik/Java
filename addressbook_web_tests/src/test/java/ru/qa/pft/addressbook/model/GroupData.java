package ru.qa.pft.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.util.Objects;

public class GroupData {
  @XStreamOmitField
  public int id = Integer.MAX_VALUE;
  private String name;
  private String header;
  private String footer;
  private String group;


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupData groupData = (GroupData) o;
    return id == groupData.id &&
            name.equals(groupData.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
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

  public GroupData withId(int id) {
    this.id = id;
    return this;
  }
  public GroupData withName(String name) {
    this.name = name;
    return this;
  }

  public GroupData withHeader(String header) {
    this.header = header;
    return this;
  }

  public GroupData withFooter(String footer) {
    this.footer = footer;
    return this;
  }
}

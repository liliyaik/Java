package ru.qa.pft.addressbook.model;

import java.util.Objects;

public class GroupData {
  private final String name;
  private final String header;
  private final String footer;
  private String group;

  public GroupData(String name, String header, String footer, String group) {
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

  public String getFooter() {
    return footer;
  }

  public String getGroup() {
    return group;
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "name='" + name + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupData groupData = (GroupData) o;
    return Objects.equals(name, groupData.name) &&
            Objects.equals(header, groupData.header) &&
            Objects.equals(footer, groupData.footer) &&
            Objects.equals(group, groupData.group);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, header, footer, group);
  }
}

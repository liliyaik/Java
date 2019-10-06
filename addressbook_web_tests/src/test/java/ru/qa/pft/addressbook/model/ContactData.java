package ru.qa.pft.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "addressbook")

public class ContactData {
  @Id
  @Column(name = "id")
    private int id = Integer.MAX_VALUE;
  @Column(name = "firstname")
    private String firstname;
  @Column(name = "lastname")
    private String lastname;
  @Column(name = "nickname")
    private String nickname;
  @Column(name = "company")
    private String company;
  @Column(name = "address")
  @Type(type = "text")
    private String address;
  @Column(name = "home")
  @Type(type = "text")
    private String homephone;
  @Column(name = "mobile")
  @Type(type = "text")
    private String mobilephone;
  @Column(name = "work")
  @Type(type = "text")
    private String workphone;
  @Column(name = "email")
  @Type(type = "text")
    private String firstemail;
  @Column(name = "email2")
  @Type(type = "text")
    private String secondemail;
  @Column(name = "email3")
  @Type(type = "text")
    private String thirdemail;

  @Column(name = "photo")
  @Type(type = "text")
  private String photo;

  public File getPhoto() {
    if (photo != null) {

      return new File(photo);

    } else {

      return null;

    }
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }

    public ContactData withId(int id) {
      this.id = id;
      return this;
    }

    public ContactData withFirstname(String firstname) {
      this.firstname = firstname;
      return this;
    }

    public ContactData withLastname(String lastname) {
      this.lastname = lastname;
      return this;
    }

    public ContactData withNickname(String nickname) {
      this.nickname = nickname;
      return this;
    }

    public ContactData withCompany(String company) {
      this.company = company;
      return this;
    }

    public ContactData withAddress(String address) {
      this.address = address;
      return this;
    }

    public ContactData withHomephone(String homephone) {
      this.homephone = homephone;
      return this;
    }

    public ContactData withMobilephone(String mobilephone) {
      this.mobilephone = mobilephone;
      return this;
    }

    public ContactData withWorkphone(String workphone) {
      this.workphone = workphone;
      return this;
    }


    public ContactData withFirstemail(String firstemail) {
      this.firstemail = firstemail;
      return this;
    }

    public ContactData withSecondemail(String secondemail) {
      this.secondemail = secondemail;
      return this;
    }

    public ContactData withThirdemail(String thirdemail) {
      this.thirdemail = thirdemail;
      return this;
    }


//    public ContactData withGroup(String group) {
//      this.group = group;
//      return this;
//    }


  public int getId() {
      return id;
    }

    public String getFirstname() {
      return firstname;
    }

    public String getLastname() {
      return lastname;
    }

    public String getNickname() {
      return nickname;
    }

    public String getCompany() {
      return company;
    }

    public String getAddress() {
      return address;
    }

    public String getHomephone() {
      return homephone;
    }

    public String getMobilephone() {
      return mobilephone;
    }

    public String getWorkphone() {
      return workphone;
    }

    public String getFirstemail() {
      return firstemail;
    }

    public String getSecondemail() {
      return secondemail;
    }

    public String getThirdemail() {
      return thirdemail;
    }

  public Groups getGroups() {
    return new Groups(groups);
  }

  @Override
  public String toString() {
    return "ContactInformation{" +
            "firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname) &&
            Objects.equals(nickname, that.nickname) &&
            Objects.equals(company, that.company);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, lastname, nickname, company);
  }

  public ContactData inGroup(GroupData group) {
    groups.add(group);
    return this;}

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "address_in_groups", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
  private Set<GroupData> groups = new HashSet<GroupData>();

    }


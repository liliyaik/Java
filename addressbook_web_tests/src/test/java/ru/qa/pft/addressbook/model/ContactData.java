package ru.qa.pft.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;

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

  @Transient
    private String allPhones;
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

  public void setAllPhones(String allPhones) {
    this.allPhones = allPhones;
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

    public ContactData withAllPhones(String allPhones) {
      this.allPhones = allPhones;
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

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", nickname='" + nickname + '\'' +
            ", company='" + company + '\'' +
            ", address='" + address + '\'' +
            ", homephone='" + homephone + '\'' +
            ", mobilephone='" + mobilephone + '\'' +
            ", workphone='" + workphone + '\'' +
            ", firstemail='" + firstemail + '\'' +
            ", secondemail='" + secondemail + '\'' +
            ", thirdemail='" + thirdemail + '\'' +
            ", allPhones='" + allPhones + '\'' +
            '}';
  }


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

    public String getAllPhones() {
      return allPhones;
    }

    public String getWorkphone() {
      return workphone;
    }

//    public String getGroup() {
//      return group;
//    }

    public String getFirstemail() {
      return firstemail;
    }

    public String getSecondemail() {
      return secondemail;
    }

    public String getThirdemail() {
      return thirdemail;
    }



    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      ContactData that = (ContactData) o;
      if (id != that.id) return false;
      if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
      return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
    }

    @Override
    public int hashCode() {
      int result = id;
      result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
      result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
      return result;
    }
  }
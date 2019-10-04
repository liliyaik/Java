package ru.stqa.pft.mantis.model;



public class UserData {
  public UserData(){}
  public UserData(String username, String email){
    this.username = username;
    this.email = email;
  }
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  private String username;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  private String email;

  @Override
  public String toString() {
    return "UserData{" +
            "username='" + username + '\'' +
            ", email='" + email + '\'' +
            '}';
  }
}


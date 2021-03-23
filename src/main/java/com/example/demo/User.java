package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class User {
  @Id
  @Size(max = 30)
  @NotBlank(message = "Id is mandatory")
  private String id;

  @Size(max = 100)
  @NotBlank(message = "must fill in")
  private String firstName;

  @Size(max = 100)
  @NotBlank(message = "must fill in")
  private String lastName;

  //region Generated
  protected User() {
  }

  public User(String id,String firstName,String lastName) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
  }


  @Override
  public String toString() {
    return "User{" + "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + '}';
  }

  public String getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }
  //endregion
}

package org.launchcode.codingevents3.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Event {

  private Integer id;
  private static int nextId = 1;

  @NotBlank(message = "Name is required, Please enter a name.")
  @Size(min = 3, max = 26, message = "Name must be between 3 and 26 characters.")
  private String name;

  @Size(max = 500, message = "The description is too long! 500 character limit.")
  private String description;

  @NotBlank(message = "Email is required, Please enter an email address.")
  @Email(message = "Email format was bad, please check the address.")
  private String contactEmail;


  public Event(String name, String description, String contactEmail) {
    this();
    this.name = name;
    this.description = description;
    this.contactEmail = contactEmail;
  }

  public Event(){
    this.id = nextId;
    nextId++;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getContactEmail() {
    return contactEmail;
  }

  public void setContactEmail(String contactEmail) {
    this.contactEmail = contactEmail;
  }

  public Integer getId() {
    return id;
  }

  @Override
  public String toString() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Event event = (Event) o;
    return id == event.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}

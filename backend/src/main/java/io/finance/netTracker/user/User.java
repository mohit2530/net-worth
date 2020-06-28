package io.finance.netTracker.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  private Long id;

  private String firstName;
  private String email;

  public User() {
  }

  public User(String firstName, String email) {
    this.firstName = firstName;
    this.email = email;
  }

  public Long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getEmail() {
    return email;
  }
}

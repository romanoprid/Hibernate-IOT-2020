package ua.lviv.iot.model.implementation;


import ua.lviv.iot.model.IGeneralModel;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "initialization", schema = "roman_oprysk_test")
public class Initialization implements IGeneralModel {


  private static final String tableName = Initialization.class.getSimpleName();
  private Integer id;
  private String login;
  private User userId;

  public Initialization(Integer id, String login, User userId) {
    this.id = id;
    this.login = login;
    this.userId = userId;
  }

  public Initialization() {

  }

  public static String getTableName() {
    return tableName;
  }
  @Id
  @Column(name = "id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  @Basic
  @Column(name = "login")
  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }




  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Initialization initialization = (Initialization) o;
    return Objects.equals(id, initialization.id) &&
            Objects.equals(login, initialization.login) &&
            Objects.equals(userId, initialization.userId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, login, userId);
  }

  @ManyToOne
  @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
  public User getUserId() {
    return userId;
  }

  public void setUserId(User userId) {
    this.userId = userId;
  }

  @Override
  public String toString() {
    return "Initialization{"
            + "id=" + id
            + ", login='" + login + '\''
            + ", user_id=" + userId
            + '}';
  }
}


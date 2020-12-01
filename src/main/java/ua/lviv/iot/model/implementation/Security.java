package ua.lviv.iot.model.implementation;


import ua.lviv.iot.model.IGeneralModel;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "security", schema = "roman_oprysk")
public class Security implements IGeneralModel {


  private static final String tableName = Security.class.getSimpleName();

  private Integer id;
  private String password;
  private User userId;

  public Security(Integer id, String password, User userId) {
    this.id = id;
    this.password = password;
    this.userId = userId;
  }

  public Security() {

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
  @Column(name = "password")

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }



  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Security security = (Security) o;
    return Objects.equals(id, security.id) &&
            Objects.equals(password, security.password) &&
            Objects.equals(userId, security.userId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, password, userId);
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
    return "Security{"
            + "id=" + id
            + ", password='"
            + password + '\''
            + ", user_id="
            + userId
            + '}';
  }
}
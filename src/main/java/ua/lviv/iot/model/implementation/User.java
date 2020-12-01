package ua.lviv.iot.model.implementation;


import ua.lviv.iot.model.IGeneralModel;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "user", schema = "roman_oprysk_test")
public class User implements IGeneralModel {


  private static final String tableName = User.class.getSimpleName();

  private Integer id;
  private String name;
  private Integer birthDate;
  private Integer followers;
  private Integer followings;
  private Integer posts;


  public User(Integer id, String name, Integer birthDate, Integer followers, Integer followings, Integer posts) {
    this.id = id;
    this.name = name;
    this.birthDate = birthDate;
    this.followers = followers;
    this.followings = followings;
    this.posts = posts;
  }

  public User() {

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
  @Column(name = "name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Basic
  @Column(name = "birth_date")
  public Integer getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Integer birthDate) {
    this.birthDate = birthDate;
  }


  @Basic
  @Column(name = "followers")
  public Integer getFollowers() {
    return followers;
  }

  public void setFollowers(Integer followers) {
    this.followers = followers;
  }


  @Basic
  @Column(name = "followings")
  public Integer getFollowings() {
    return followings;
  }

  public void setFollowings(Integer followings) {
    this.followings = followings;
  }


  @Basic
  @Column(name = "posts")
  public Integer getPosts() {
    return posts;
  }

  public void setPosts(Integer posts) {
    this.posts = posts;
  }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return Objects.equals(id, user.id) &&
            Objects.equals(name, user.name) &&
            Objects.equals(birthDate, user.birthDate) &&
            Objects.equals(followers, user.followers) &&
            Objects.equals(followings, user.followings) &&
            Objects.equals(posts, user.posts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, birthDate, followers, followings, posts);
  }




  @Override
  public String toString() {
    return "User{"
            + "id=" + id
            + ", name='" + name + '\''
            + ", birth_date=" + birthDate
            + ", followers=" + followers
            + ", followings=" + followings
            + ", posts=" + posts
            + '}';
  }
}
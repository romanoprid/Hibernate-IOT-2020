package ua.lviv.iot.model.implementation;


import ua.lviv.iot.model.IGeneralModel;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "story", schema = "roman_oprysk")
public class Story implements IGeneralModel {


  private static final String tableName = Story.class.getSimpleName();

  private Integer id;
  private String bloger;
  private String link;
  private Integer addTime;
  private String content;
  private Integer likeNumber;
  private Integer shareNumber;
  private User userId;

  public Story(Integer id, String bloger, String link, Integer addTime, String content, Integer likeNumber,
               Integer shareNumber,User userId) {
    this.id = id;
    this.bloger = bloger;
    this.link = link;
    this.addTime = addTime;
    this.content = content;
    this.likeNumber = likeNumber;
    this.shareNumber = shareNumber;
    this.userId = userId;
  }

  public Story() {

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
  @Column(name = "bloger")

  public String getBloger() {
    return bloger;
  }

  public void setBloger(String bloger) {
    this.bloger = bloger;
  }


  @Basic
  @Column(name = "link")
  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }


  @Basic
  @Column(name = "add_time")
  public Integer getAddTime() {
    return addTime;
  }

  public void setAddTime(Integer addTime) {
    this.addTime = addTime;
  }


  @Basic
  @Column(name = "content")
  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  @Basic
  @Column(name = "like_number")
  public Integer getLikeNumber() {
    return likeNumber;
  }

  public void setLikeNumber(Integer likeNumber) {
    this.likeNumber = likeNumber;
  }


  @Basic
  @Column(name = "share_number")
  public Integer getShareNumber() {
    return shareNumber;
  }

  public void setShareNumber(Integer shareNumber) {
    this.shareNumber = shareNumber;
  }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Story story = (Story) o;
    return Objects.equals(id, story.id) &&
            Objects.equals(bloger, story.bloger) &&
            Objects.equals(link, story.link) &&
            Objects.equals(addTime, story.addTime) &&
            Objects.equals(content, story.content) &&
            Objects.equals(likeNumber, story.likeNumber) &&
            Objects.equals(shareNumber, story.shareNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, bloger, link, addTime, content, likeNumber, shareNumber);
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
    return "Story{"
            + "id=" + id
            + ", bloger='" + bloger + '\''
            + ", link='" + link + '\''
            + ", add_time=" + addTime
            + ", content='" + content + '\''
            + ", like_number=" + likeNumber
            + ", share_number=" + shareNumber
            + '}';
  }
}
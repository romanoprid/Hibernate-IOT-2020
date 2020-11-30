package ua.lviv.iot.model.implementation;


import ua.lviv.iot.dao.implementation.GeneralDao;
import ua.lviv.iot.model.IGeneralModel;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "save_on_top", schema = "roman_oprysk4")
public  class SaveOnTop implements IGeneralModel  {


  public static String getTableName() {
    return tableName;
  }

  private static final String tableName = SaveOnTop.class.getSimpleName();

  private Integer id;
  private Integer position;
  private String status;
  private Story storyId;
  public SaveOnTop(Integer id, Integer position, String status, Story storyId) {
    this.id = id;
    this.position = position;
    this.status = status;
    this.storyId = storyId;
  }

  public SaveOnTop() {

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
  @Column(name = "positon")
  public Integer getPosition() {
    return position;
  }

  public void setPosition(Integer position) {
    this.position = position;
  }


  @Basic
  @Column(name = "status")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }



  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    SaveOnTop saveOnTop = (SaveOnTop) o;
    return Objects.equals(id, saveOnTop.id) &&
            Objects.equals(position, saveOnTop.position) &&
            Objects.equals(status, saveOnTop.status) &&
            Objects.equals(storyId, saveOnTop.storyId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, position, status, storyId);
  }

  @ManyToOne
  @JoinColumn(name = "story_id", referencedColumnName = "id", nullable = false)
  public Story getStoryId() {
    return storyId;
  }

  public void setStoryId(Story storyId) {
    this.storyId = storyId;
  }

  @Override
  public String toString() {
    return "SaveOnTop{"
            + "id=" + id
            + ", position=" + position
            + ", status='" + status + '\''
            + ", story_id=" + storyId
            + '}';
  }
}

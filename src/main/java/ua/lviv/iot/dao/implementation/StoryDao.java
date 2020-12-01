package ua.lviv.iot.dao.implementation;


import ua.lviv.iot.model.implementation.Story;


public class StoryDao extends GeneralDao<Story> {
  public final Class<Story> getClazz() {
    return Story.class;

  }
}
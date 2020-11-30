package ua.lviv.iot.service.implementation;


import ua.lviv.iot.dao.IGeneralDao;
import ua.lviv.iot.dao.implementation.GeneralDao;
import ua.lviv.iot.dao.implementation.StoryDao;
import ua.lviv.iot.model.implementation.Story;

public class StoryService extends GeneralService<Story> {
    private final GeneralDao<Story> STORY_DAO = new StoryDao();

    @Override
    public IGeneralDao<Story> getDAO() {
      return STORY_DAO;
    }
  }
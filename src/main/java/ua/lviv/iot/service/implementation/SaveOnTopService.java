package ua.lviv.iot.service.implementation;


import ua.lviv.iot.dao.IGeneralDao;
import ua.lviv.iot.dao.implementation.GeneralDao;
import ua.lviv.iot.dao.implementation.InitializationDao;
import ua.lviv.iot.dao.implementation.SaveOnTopDao;
import ua.lviv.iot.model.implementation.Initialization;
import ua.lviv.iot.model.implementation.SaveOnTop;

public class SaveOnTopService extends GeneralService<SaveOnTop> {
  private final GeneralDao<SaveOnTop> SAVE_ON_TOP_DAO = new SaveOnTopDao();

  @Override
  public IGeneralDao<SaveOnTop> getDAO() {
    return SAVE_ON_TOP_DAO;
  }
}
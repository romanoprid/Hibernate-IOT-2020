package ua.lviv.iot.service.implementation;


import ua.lviv.iot.dao.IGeneralDao;
import ua.lviv.iot.dao.implementation.GeneralDao;
import ua.lviv.iot.dao.implementation.InitializationDao;
import ua.lviv.iot.model.implementation.Initialization;

public class InitializationService extends GeneralService<Initialization> {
  private final GeneralDao<Initialization> INITIALIZATION_DAO = new InitializationDao();

  @Override
  public IGeneralDao<Initialization> getDAO() {
    return INITIALIZATION_DAO;
  }
}

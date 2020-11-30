package ua.lviv.iot.service.implementation;


import ua.lviv.iot.dao.IGeneralDao;
import ua.lviv.iot.dao.implementation.GeneralDao;
import ua.lviv.iot.dao.implementation.SecurityDao;
import ua.lviv.iot.model.implementation.Security;

public class SecurityService extends GeneralService<Security> {
  private final GeneralDao<Security> SECURITY_DAO = new SecurityDao();

  @Override
  public IGeneralDao<Security> getDAO() {
    return SECURITY_DAO;
  }
}
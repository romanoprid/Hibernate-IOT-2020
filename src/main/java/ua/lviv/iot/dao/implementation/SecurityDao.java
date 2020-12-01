package ua.lviv.iot.dao.implementation;


import ua.lviv.iot.model.implementation.Security;


public class SecurityDao extends GeneralDao<Security> {
  public final Class<Security> getClazz() {
    return Security.class;

  }
}
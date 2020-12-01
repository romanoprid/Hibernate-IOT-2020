package ua.lviv.iot.controller.implementation;


import ua.lviv.iot.model.implementation.Security;
import ua.lviv.iot.service.IGeneralService;
import ua.lviv.iot.service.implementation.GeneralService;
import ua.lviv.iot.service.implementation.SecurityService;

public class SecurityController extends GeneralController<Security> {

  private final GeneralService<Security> securityService = new SecurityService();

  @Override
  public final IGeneralService<Security> getService() {
    return securityService;
  }

}
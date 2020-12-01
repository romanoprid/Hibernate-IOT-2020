package ua.lviv.iot.controller.implementation;


import ua.lviv.iot.model.implementation.Initialization;
import ua.lviv.iot.service.IGeneralService;
import ua.lviv.iot.service.implementation.GeneralService;
import ua.lviv.iot.service.implementation.InitializationService;

public class InitializationController extends GeneralController<Initialization> {

  private final GeneralService<Initialization> initializationService = new InitializationService();

  @Override
  public final IGeneralService<Initialization> getService() {
    return initializationService;
  }

}

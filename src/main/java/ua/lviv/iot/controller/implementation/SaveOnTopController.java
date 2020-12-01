package ua.lviv.iot.controller.implementation;


import ua.lviv.iot.model.implementation.SaveOnTop;
import ua.lviv.iot.service.IGeneralService;
import ua.lviv.iot.service.implementation.GeneralService;
import ua.lviv.iot.service.implementation.SaveOnTopService;

public class SaveOnTopController extends GeneralController<SaveOnTop> {

  private final GeneralService<SaveOnTop> saveOnTopService = new SaveOnTopService();

  @Override
  public final IGeneralService<SaveOnTop> getService() {
    return saveOnTopService;
  }

}
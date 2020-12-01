package ua.lviv.iot.controller.implementation;


import ua.lviv.iot.model.implementation.Story;
import ua.lviv.iot.service.IGeneralService;
import ua.lviv.iot.service.implementation.GeneralService;
import ua.lviv.iot.service.implementation.StoryService;

public class StoryController extends GeneralController<Story> {

  private final GeneralService<Story> storyService = new StoryService();

  @Override
  public final IGeneralService<Story> getService() {
    return storyService;
  }

}

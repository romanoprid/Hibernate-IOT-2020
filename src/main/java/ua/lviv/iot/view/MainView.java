package ua.lviv.iot.view;


import org.hibernate.Session;
import ua.lviv.iot.controller.implementation.*;
import ua.lviv.iot.model.implementation.*;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MainView {
  private final InitializationController initializationController = new InitializationController();
  private final SaveOnTopController saveOnTopController = new SaveOnTopController();
  private final SecurityController securityController = new SecurityController();
  private final StoryController storyController = new StoryController();
  private final UserController userController = new UserController();


  private final Map<String, String> menu;
  private final Map<String, Printable> methodsMenu;
  private static final Scanner INPUT = new Scanner(System.in);

  public MainView(Session session) {
    menu = new LinkedHashMap<>();
    methodsMenu = new LinkedHashMap<>();

    menu.put("11", "11 - Get all initializations");
    menu.put("12", "12 - Get initialization by ID");
    menu.put("13", "13 - Create initialization");
    menu.put("14", "14 - Delete initialization by ID");
    menu.put("15", "15 - Update initialization by ID");

    menu.put("21", "21 - Get all saveOnTops");
    menu.put("22", "22 - Get saveOnTop by ID");
    menu.put("23", "23 - Create saveOnTop");
    menu.put("24", "24 - Delete saveOnTop by ID");
    menu.put("25", "25 - Update saveOnTop by ID");

    menu.put("31", "31 - Get all securities");
    menu.put("32", "32 - Get security by ID");
    menu.put("33", "33 - Create security");
    menu.put("34", "34 - Delete security by ID");
    menu.put("35", "35 - Update security by ID");

    menu.put("41", "41 - Get all stories");
    menu.put("42", "42 - Get story by ID");
    menu.put("43", "43 - Create story");
    menu.put("44", "44 - Delete story by ID");
    menu.put("45", "45 - Update story by ID");

    menu.put("51", "51 - Get all users");
    menu.put("52", "52 - Get user by ID");
    menu.put("53", "53 - Create user");
    menu.put("54", "54 - Delete user by ID");
    menu.put("55", "55 - Update user  by ID");


    methodsMenu.put("11", () -> getAllInitializations(session));
    methodsMenu.put("12", () -> getInitializationById(session));
    methodsMenu.put("13", () -> createInitialization(session));
    methodsMenu.put("14", () -> deleteInitializationById(session));
    methodsMenu.put("15", () -> updateInitializationById(session));

    methodsMenu.put("21", () -> getAllSaveOnTops(session));
    methodsMenu.put("22", () -> getSaveOnTopById(session));
    methodsMenu.put("23", () -> createSaveOnTop(session));
    methodsMenu.put("24", () -> deleteSaveOnTopById(session));
    methodsMenu.put("25", () -> updateSaveOnTopById(session));

    methodsMenu.put("31", () -> getAllSecurities(session));
    methodsMenu.put("32", () -> getSecurityById(session));
    methodsMenu.put("33", () -> createSecurity(session));
    methodsMenu.put("34", () -> deleteSecurityById(session));
    methodsMenu.put("35", () -> updateSecurityById(session));

    methodsMenu.put("41", () -> getAllStories(session));
    methodsMenu.put("42", () -> getStoryById(session));
    methodsMenu.put("43", () -> createStory(session));
    methodsMenu.put("44", () -> deleteStoryById(session));
    methodsMenu.put("45", () -> updateStoryById(session));

    methodsMenu.put("51", () -> getAllUsers(session));
    methodsMenu.put("52", () -> getUserById(session));
    methodsMenu.put("53", () -> createUser(session));
    methodsMenu.put("54", () -> deleteUserById(session));
    methodsMenu.put("55", () -> updateUserById(session));

  }


  private void getAllInitializations(Session session) throws SQLException {
    System.out.println("\nTable: initialization");
    initializationController.getAll(session);
  }

  private void getInitializationById(Session session) throws SQLException {
    System.out.println("Enter ID for Initialization: ");
    int id = INPUT.nextInt();
    INPUT.nextLine();
    initializationController.getById(id, session);
  }

  private void createInitialization(Session session) throws SQLException {
    System.out.println("Enter new initialization login: ");
    String login = INPUT.nextLine();
    System.out.println("Enter new initialization user_id: ");
    INPUT.nextLine();
    Initialization entity = new Initialization(0, login);
    initializationController.create(entity, session);
  }

  private void deleteInitializationById(Session session) throws SQLException {
    System.out.println("Enter ID to delete initialization: ");
    int id = INPUT.nextInt();
    INPUT.nextLine();
    initializationController.delete(id, session);
  }

  private void updateInitializationById(Session session) throws SQLException {
    System.out.println("Enter initialization id to update: ");
    int id = INPUT.nextInt();
    INPUT.nextLine();
    Initialization oldInitialization = initializationController.getService().getById(id, session);
    System.out.println("Enter new initialization login: ");
    String login = INPUT.nextLine();
    System.out.println("Enter new initialization user_id: ");
    int userId = INPUT.nextInt();
    INPUT.nextLine();

    String newLogin = login;
    Integer newUserId = userId;

    if (login.equals("")) {
      newLogin = oldInitialization.getLogin();
    }


    Initialization entity = new Initialization(id, newLogin);
    initializationController.update(entity, session);
  }


  private void getAllSaveOnTops(Session session) throws SQLException {
    System.out.println("\nTable: saveOnTop");
    saveOnTopController.getAll(session);
  }

  private void getSaveOnTopById(Session session) throws SQLException {
    System.out.println("Enter ID for SaveOnTop: ");
    int id = INPUT.nextInt();
    INPUT.nextLine();
    saveOnTopController.getById(id, session);
  }

  private void createSaveOnTop(Session session) throws SQLException {
    System.out.println("Enter new saveOnTop position: ");
    int position = INPUT.nextInt();
    System.out.println("Enter new saveOnTop status: ");
    String status = INPUT.nextLine();
    System.out.println("Enter new saveOnTop story_id: ");
    int storyId = INPUT.nextInt();
    INPUT.nextLine();
    SaveOnTop entity = new SaveOnTop(0, position, status);
    saveOnTopController.create(entity, session);
  }

  private void deleteSaveOnTopById(Session session) throws SQLException {
    System.out.println("Enter ID to delete SaveOnTop: ");
    int id = INPUT.nextInt();
    INPUT.nextLine();
    saveOnTopController.delete(id, session);
  }

  private void updateSaveOnTopById(Session session) throws SQLException {
    System.out.println("Enter saveOnTop id to update: ");
    int id = INPUT.nextInt();
    INPUT.nextLine();
    SaveOnTop oldSaveOnTop = saveOnTopController.getService().getById(id, session);
    System.out.println("Enter new saveOnTop position: ");
    int position = INPUT.nextInt();
    System.out.println("Enter new saveOnTop status: ");
    String status = INPUT.nextLine();
    System.out.println("Enter new saveOnTop story_id: ");
    int storyId = INPUT.nextInt();
    INPUT.nextLine();

    Integer newPosition = position;
    String newStatus = status;
    Integer newStoryID = storyId;

    if (position < 0) {
      newPosition = oldSaveOnTop.getPosition();
    }

    if (status.equals("")) {
      newStatus = oldSaveOnTop.getStatus();
    }




    SaveOnTop entity = new SaveOnTop(id, newPosition, newStatus);
    saveOnTopController.update(entity, session);
  }


  private void getAllSecurities(Session session) throws SQLException {
    System.out.println("\nTable: security");
    securityController.getAll(session);
  }

  private void getSecurityById(Session session) throws SQLException {
    System.out.println("Enter ID for Security: ");
    int id = INPUT.nextInt();
    INPUT.nextLine();
    securityController.getById(id, session);
  }

  private void createSecurity(Session session) throws SQLException {
    System.out.println("Enter new  password: ");
    String password = INPUT.nextLine();
    System.out.println("Enter new  user ID: ");

    INPUT.nextLine();
    Security entity = new Security(0, password);
    securityController.create(entity, session);
  }

  private void deleteSecurityById(Session session) throws SQLException {
    System.out.println("Enter ID to delete Story: ");
    int id = INPUT.nextInt();
    INPUT.nextLine();
    securityController.delete(id, session);
  }

  private void updateSecurityById(Session session) throws SQLException {
    System.out.println("Enter story ID to update: ");
    int id = INPUT.nextInt();
    INPUT.nextLine();
    Security oldSecurity = securityController.getService().getById(id, session);
    System.out.println("Enter new password: ");
    String password = INPUT.nextLine();
    System.out.println("Enter new user ID: ");
    int userId = INPUT.nextInt();
    INPUT.nextLine();

    String newPassword = password;
    Integer newUserId = userId;


    if (password.equals("")) {
      newPassword = oldSecurity.getPassword();
    }



    Security entity = new Security(id, newPassword);
    securityController.update(entity, session);
  }


  private void getAllStories(Session session) throws SQLException {
    System.out.println("\nTable: story");
    storyController.getAll(session);
  }

  private void getStoryById(Session session) throws SQLException {
    System.out.println("Enter ID for Story: ");
    int id = INPUT.nextInt();
    INPUT.nextLine();
    storyController.getById(id, session);
  }

  private void createStory(Session session) throws SQLException {
    System.out.println("Enter new bloger: ");
    String bloger = INPUT.nextLine();
    System.out.println("Enter new link: ");
    String link = INPUT.nextLine();
    System.out.println("Enter new add_time: ");
    int addTime = INPUT.nextInt();
    System.out.println("Enter new content: ");
    String content = INPUT.nextLine();
    System.out.println("Enter new like_number: ");
    int likeNumber = INPUT.nextInt();
    System.out.println("Enter new share_number: ");
    int shareNumber = INPUT.nextInt();
    INPUT.nextLine();
    Story entity = new Story(0, bloger, link, addTime, content, likeNumber, shareNumber);
    storyController.create(entity, session);
  }

  private void deleteStoryById(Session session) throws SQLException {
    System.out.println("Enter ID to delete Story: ");
    int id = INPUT.nextInt();
    INPUT.nextLine();
    storyController.delete(id, session);
  }

  private void updateStoryById(Session session) throws SQLException {
    System.out.println("Enter story ID to update: ");
    int id = INPUT.nextInt();
    INPUT.nextLine();
    Story oldStory = storyController.getService().getById(id, session);

    System.out.println("Enter new bloger: ");
    String bloger = INPUT.nextLine();
    System.out.println("Enter new link: ");
    String link = INPUT.nextLine();
    System.out.println("Enter new add_time: ");
    int addTime = INPUT.nextInt();
    System.out.println("Enter new content: ");
    String content = INPUT.nextLine();
    System.out.println("Enter new like_number: ");
    int likeNumber = INPUT.nextInt();
    System.out.println("Enter new share_number: ");
    int shareNumber = INPUT.nextInt();
    INPUT.nextLine();

    String newBloger = bloger;
    String newLink = link;
    Integer newAddTime = addTime;
    String newContent = content;
    Integer newLikeNumber = likeNumber;
    Integer newShareNumber = shareNumber;

    if (bloger.equals("")) {
      newBloger = oldStory.getBloger();
    }
    if (link.equals("")) {
      newLink = oldStory.getLink();
    }
    if (addTime < 0) {
      newAddTime = oldStory.getAddTime();
    }
    if (content.equals("")) {
      newContent = oldStory.getContent();
    }
    if (likeNumber < 0) {
      newLikeNumber = oldStory.getLikeNumber();
    }
    if (shareNumber < 0) {
      newShareNumber = oldStory.getShareNumber();
    }

    Story entity = new Story(id, newBloger, newLink, newAddTime, newContent, newLikeNumber, newShareNumber);
    storyController.update(entity, session);
  }


  private void getAllUsers(Session session) throws SQLException {
    System.out.println("\nTable: user");
    userController.getAll(session);
  }

  private void getUserById(Session session) throws SQLException {
    System.out.println("Enter ID for user: ");
    int id = INPUT.nextInt();
    INPUT.nextLine();
    userController.getById(id, session);
  }

  private void createUser(Session session) throws SQLException {
    System.out.println("Enter new name: ");
    String name = INPUT.nextLine();
    System.out.println("Enter new birth_date: ");
    int birthDate = INPUT.nextInt();
    System.out.println("Enter new  followers: ");
    int followers = INPUT.nextInt();
    System.out.println("Enter new followings: ");
    Integer followings = INPUT.nextInt();
    System.out.println("Enter new posts: ");
    int posts = INPUT.nextInt();
    INPUT.nextLine();
    User entity = new User(0, name, birthDate, followers, followings, posts);
    userController.create(entity, session);
  }

  private void deleteUserById(Session session) throws SQLException {
    System.out.println("Enter ID to delete User: ");
    int id = INPUT.nextInt();
    INPUT.nextLine();
    userController.delete(id, session);
  }

  private void updateUserById(Session session) throws SQLException {
    System.out.println("Enter user ID to update: ");
    int id = INPUT.nextInt();
    INPUT.nextLine();
    User oldUser = userController.getService().getById(id, session);
    System.out.println("Enter new name: ");
    String name = INPUT.nextLine();
    System.out.println("Enter new birth_date: ");
    int birthDate = INPUT.nextInt();
    System.out.println("Enter new  followers: ");
    int followers = INPUT.nextInt();
    System.out.println("Enter new followings: ");
    int followings = INPUT.nextInt();
    System.out.println("Enter new posts: ");
    int posts = INPUT.nextInt();
    INPUT.nextLine();

    String newName = name;
    Integer newBirthDate = birthDate;
    Integer newFollowers = followers;
    Integer newFollowings = followings;
    Integer newPosts = posts;


    if (name.equals("")) {
      newName = oldUser.getName();
    }
    if (birthDate < 0) {
      newBirthDate = oldUser.getBirthDate();
    }
    if (followers < 0) {
      newFollowers = oldUser.getFollowers();
    }
    if (followings < 0) {
      newFollowings = oldUser.getFollowings();
    }
    if (posts < 0) {
      newPosts = oldUser.getPosts();
    }

    User entity = new User(id, newName, newBirthDate, newFollowers, newFollowings, newPosts);
    userController.update(entity, session);
  }


  private void outputMenu() {
    System.out.println("\nMENU:");
    for (String str : menu.values()) {
      System.out.println(str);
    }
  }

  public final void show() {
    String keyMenu;
    do {
      outputMenu();
      System.out.println("Please, select menu point.");
      keyMenu = INPUT.nextLine().toUpperCase();
      try {
        methodsMenu.get(keyMenu).print();
      } catch (Exception ignored) {
      }
    } while (!keyMenu.equals("Q"));
  }
}
package main.model.dao;

import main.model.pojo.User;

/**
 * Created by Shoma on 20.04.2017.
 */
public interface UserDao {
User findUserByLoginAndPassword(String login, String password);
 void deleteUser(int i);
}

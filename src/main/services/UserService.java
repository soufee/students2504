package main.services;

import main.model.pojo.User;

/**
 * Created by Shoma on 20.04.2017.
 */


public interface UserService {
    User auth (String login, String password);
}

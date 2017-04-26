package main.services;

import main.controllers.listeners.MySessionListener;
import main.model.dao.UserDao;
import main.model.pojo.User;
import main.qouters.Profiling;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * Created by Shoma on 20.04.2017.
 */
@Profiling
@Component
public class UserServiceImpl implements UserService{
    private static Logger LOGGER  = Logger.getLogger(MySessionListener.class);
    private   UserDao userDAO;

    public UserDao getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDao userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User auth(String login, String password) {
        User user = userDAO.findUserByLoginAndPassword(login, password);


        if (user != null && user.isBlocked()) {
            return null;
        }
        return user;
    }

    public void userDel(int i)
    {
        userDAO.deleteUser(i);
    }

    }


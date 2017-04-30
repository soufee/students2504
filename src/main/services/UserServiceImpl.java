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

@Component
public class UserServiceImpl implements UserService{
    private static Logger LOGGER  = Logger.getLogger(MySessionListener.class);

       UserDao userDAO;

    public UserDao getUserDAO() {
        LOGGER.debug("Возвращаем USERDAO "+userDAO);
        return userDAO;
    }

    public void setUserDAO(UserDao userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User auth(String login, String password) {
        LOGGER.debug("Попытка авторизации. Login: "+login+" password: "+password);
        User user = userDAO.findUserByLoginAndPassword(login, password);


        if (user != null && user.isBlocked()) {
            return null;
        }
        LOGGER.debug("Возвращаем USER "+user);
        return user;
    }

    public void userDel(int i)
    {
        userDAO.deleteUser(i);
    }

    }


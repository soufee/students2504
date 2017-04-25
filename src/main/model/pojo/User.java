package main.model.pojo;

import main.controllers.listeners.MySessionListener;
import org.apache.log4j.Logger;

/**
 * Created by Shoma on 20.04.2017.
 */
public class User {
    private int id;
    private String login;
    private String password;
    private boolean isBlocked;
    private static Logger LOGGER  = Logger.getLogger(MySessionListener.class);
    public User(int id, String login, String password, boolean isBlocked) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.isBlocked = isBlocked;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlock(boolean block) {
        isBlocked = block;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

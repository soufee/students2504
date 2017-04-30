package main.model.dao;

import main.controllers.listeners.MySessionListener;
import main.model.connection.ConnectionFactory;
import main.model.pojo.User;
import org.apache.log4j.Logger;
import org.postgresql.util.PSQLException;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by Shoma on 20.04.2017.
 */

public class UserDAOimpl implements UserDao {

    private static Logger LOGGER = Logger.getLogger(MySessionListener.class);

    public User findUserByLoginAndPassword(String login, String password) {
        User user = null;
        PreparedStatement statement;
        LOGGER.debug("Ищем юзера");
        try (Connection connection = ConnectionFactory.getConnection()) {
            statement = connection.prepareStatement("SELECT * FROM public.user_tb WHERE login = ? AND password = ?");
            LOGGER.debug("Делаем запрос в базу данных public.user_tb");
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = createEntity(resultSet);
                LOGGER.debug("user получен "+user);
            }

        } catch (SQLException e) {
            LOGGER.debug(e.getMessage());
            e.printStackTrace();
        }
        LOGGER.debug("Возвращаем юзера "+user);
        return user;
    }

    private User createEntity(ResultSet resultSet) throws SQLException {
        return new User(resultSet.getInt("id"),
                resultSet.getString("login"),
                resultSet.getString("password"),
                resultSet.getBoolean("blocked"));
    }

    public void deleteUser(int i) {
        PreparedStatement statement = null;
        try (Connection connection = ConnectionFactory.getConnection()) {

            statement = connection.prepareStatement("DELETE FROM public.user_t WHERE id = " + i);
            statement.executeQuery();


        } catch (PSQLException e) {
            System.out.println(e.getServerErrorMessage());

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }


}

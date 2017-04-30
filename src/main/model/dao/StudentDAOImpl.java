package main.model.dao;

import main.controllers.listeners.MySessionListener;

import main.model.connection.ConnectionFactory;
import main.model.pojo.Student;
import main.services.StudentServiceImpl;
import org.apache.log4j.Logger;
import org.postgresql.util.PSQLException;
import main.services.StudentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shoma on 18.04.2017.
 */
@Component
public class StudentDAOImpl implements StudentDAOInterface {

    private static Logger LOGGER = Logger.getLogger(MySessionListener.class);


    public List<Student> getAllStudents() {
        LOGGER.debug("Вызван метод getAllStudents");
        ArrayList<Student> list = new ArrayList<Student>();
        Student q1 = null;
        try {
            Connection connection = ConnectionFactory.getConnection();
            LOGGER.debug("Устанавливается Connection в методе getAllStudents");
            Statement statement = connection.createStatement();
            LOGGER.debug("Устанавливается statement");
            ResultSet result = statement.executeQuery("select * from public.student");
            LOGGER.debug("Вызван SQL запрос select * from public.student");
            while (result.next()) {
                q1 = new Student();
                q1.setId(result.getInt(1));
                q1.setName(result.getString(2));
                q1.setAge(result.getInt(3));
                q1.setGroup_id(result.getInt(4));
                list.add(q1);
                //        System.out.println(list.size());;
            }
            statement.close();
            result.close();
            connection.close();
            LOGGER.debug("Закрываются statement, result и connection");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            LOGGER.debug("Ошибка SQL" + e.getMessage());
        }
        return list;
    }

    public boolean updateById(Student s, Integer i) {
        Connection connection = ConnectionFactory.getConnection();
        LOGGER.debug("Установлено соединение в методе updateById класса " + this.getClass().getName());
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("UPDATE public.student SET name = '"
                    + s.getName() + "', age = " + s.getAge() + ", group_id = " + s.getGroup_id() + " WHERE id = " + i);
            LOGGER.debug("Вызван SQL запрос UPDATE");
            statement.executeQuery();
            return true;
        } catch (PSQLException e) {
            LOGGER.debug("Ошибка PSQL " + e.getMessage());
            return false;
        } catch (SQLException e) {
            LOGGER.debug("Ошибка SQL " + e.getMessage());
            return false;
        }

    }

    public boolean updateByName(Student s, String l) {
        PreparedStatement statement = null;
        Connection connection = ConnectionFactory.getConnection();
        LOGGER.debug("Установлено соединение в методе updateByName класса " + this.getClass().getName());
        try {
            statement = connection.prepareStatement("UPDATE public.student SET name = '" + s.getName() + "'," +
                    "age=" + s.getAge() + ", group_id=" + s.getGroup_id() + " WHERE name = '" + l + "'");
            statement.executeQuery();
            LOGGER.debug("Вызван SQL запрос UPDATE");
            return true;
        } catch (PSQLException e) {
            LOGGER.debug("Ошибка PSQL " + e.getMessage());
            return false;
        } catch (SQLException e) {
            LOGGER.debug("Ошибка SQL " + e.getMessage());
            return false;
        }
    }

    public boolean delete(Integer i) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("DELETE FROM student WHERE id = " + i);
            statement.executeQuery();

            return true;
        } catch (PSQLException e) {
            LOGGER.debug("Ошибка PSQL " + e.getMessage());
            return false;
        } catch (SQLException e) {
            LOGGER.debug("Ошибка SQL " + e.getMessage());
            return false;
        }

    }

    public boolean insert(Student s) {
        Connection connection = ConnectionFactory.getConnection();
        LOGGER.debug("Установлен connection в методе insert класса " + this.getClass().getName());
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT INTO student (name,age,group_id) VALUES ('" + s.getName() + "', "
                    + s.getAge() + ", " + s.getGroup_id() + ")");
            LOGGER.debug("Отправлен SQL запрос");
            statement.executeUpdate();

        } catch (SQLException e1) {
            LOGGER.debug("Возникла ошибка " + e1.getMessage());
        }
        return true;

    }


}

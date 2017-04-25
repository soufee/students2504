package main.model.dao;


import main.model.connection.ConnectionFactory;
import main.model.pojo.Study_group;
import org.postgresql.util.PSQLException;
import main.services.StudyGroupServiceInterface;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shoma on 18.04.2017.
 */
public class Study_groupDAO implements StudyGroupServiceInterface{
    public static Connection connection = ConnectionFactory.getConnection();

    public List<Study_group> getAllGroups() {
        ArrayList<Study_group> list = new ArrayList<Study_group>();
        Study_group q1 = null;
        try {

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select * from public.study_group");
            while (result.next()) {
                q1 = new Study_group();
                q1.setId(result.getInt(1));
                q1.setName(result.getString(2));
                           list.add(q1);

            }
            statement.close();
            result.close();
            //   connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    public boolean updateById(Study_group s, Integer i) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("UPDATE public.study_group SET name = '"
                    +s.getName()+"' WHERE id = "+i);
            statement.executeQuery();
return true;
        } catch (PSQLException e) {
                 return false;
        } catch (SQLException e) {
            e.printStackTrace();
return false;
        }
    }

    public boolean delete(Integer i) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("DELETE FROM study_group WHERE id = " + i);
            statement.executeQuery();
            return true;
        } catch (PSQLException e) {
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean insert(Study_group s) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT INTO public.study_group name VALUES ('" + s.getName() + "'");
            statement.executeUpdate();
return true;
        } catch (PSQLException e) {
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

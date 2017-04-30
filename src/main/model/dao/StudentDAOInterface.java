package main.model.dao;



import main.model.pojo.Student;

import java.util.List;

/**
 * Created by Shoma on 27.04.2017.
 */
public interface StudentDAOInterface {
    List<Student> getAllStudents();
    boolean updateById(Student s, Integer i);
    boolean updateByName(Student s, String l);
    boolean delete(Integer i);
    boolean insert(Student s);
}

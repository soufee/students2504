package main.services;

import main.controllers.listeners.MySessionListener;
import main.model.dao.StudentDAOInterface;
import main.model.pojo.Student;
import main.qouters.Profiling;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Shoma on 19.04.2017.
 */

@Component
public class StudentServiceImpl implements StudentServiceInterface {
    private static Logger LOGGER = Logger.getLogger(MySessionListener.class);
@Autowired
    private StudentDAOInterface studentDao;


    public List<Student> getAllStudents() {
        LOGGER.debug("Вызван метод getAllStudents в классе " + this.getClass().getName());
        return studentDao.getAllStudents();
    }

    public StudentDAOInterface getStudentDao() {
        return studentDao;
    }


    public void setStudentDao(StudentDAOInterface studentDao) {
        this.studentDao = studentDao;
    }

    public boolean updateById(Student s, Integer i) {
        return studentDao.updateById(s, i);
    }

    public boolean updateByName(Student s, String l) {
        return studentDao.updateByName(s, l);
    }

    public boolean delete(Integer i) {
        return studentDao.delete(i);
    }

    public boolean insert(Student s) {

        return studentDao.insert(s);
    }


}

package main.services;

import main.model.dao.Study_groupDAO;
import main.model.pojo.Study_group;

import java.util.List;

/**
 * Created by Shoma on 19.04.2017.
 *  public static StudentServiceInterface studentDAO = new StudentDAOImpl();
 public List<Student> getAllStudents()
 {
 return studentDAO.getAllStudents();
 }

 public boolean updateById(Student s, Integer i) {
 return studentDAO.updateById(s,i);
 }

 public boolean updateByName(Student s, String l) {
 return studentDAO.updateByName(s,l);
 }

 public boolean delete(Integer i) {
 return studentDAO.delete(i);
 }

 public boolean insert(Student s) {

 return studentDAO.insert(s);
 }

 *
 */
public class StudyGroupService implements StudyGroupServiceInterface {
    public static StudyGroupServiceInterface studyGroup = new Study_groupDAO();
    public List<Study_group> getAllGroups() {
        return studyGroup.getAllGroups();
    }

    public boolean updateById(Study_group s, Integer i) {
   return studyGroup.updateById(s,i);
    }

    public boolean delete(Integer i) {
    return studyGroup.delete(i);
    }

    public boolean insert(Study_group s) {
   return   studyGroup.insert(s);
    }
}

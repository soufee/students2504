package main.model.dao;

import main.model.pojo.Lesson;
import main.services.LessonServiceInterface;

import java.util.List;

/**
 * Created by Shoma on 18.04.2017.
 */
public class LessonDAO implements LessonServiceInterface{

    public List<Lesson> getAllLessons() {
        return null;
    }

    public boolean updateRoom(Lesson s, Integer i) {
        return false;
    }

    public boolean updateTime(Lesson s, Integer i) {
        return false;
    }

    public boolean updateDescription(Lesson s, Integer i) {
        return false;
    }

    public boolean delete(Integer i) {
        return false;
    }

    public boolean insert(Lesson s) {
        return false;
    }
}

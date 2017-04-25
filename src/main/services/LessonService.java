package main.services;

import main.model.pojo.Lesson;

import java.util.List;

/**
 * Created by Shoma on 19.04.2017.
 */
public class LessonService implements LessonServiceInterface{
    public static LessonServiceInterface lesson = new LessonService();
    public List<Lesson> getAllLessons() {
        return lesson.getAllLessons();
    }

    public boolean updateRoom(Lesson s, Integer i) {
        return lesson.updateRoom(s,i);
    }

    public boolean updateTime(Lesson s, Integer i) {
        return lesson.updateTime(s,i);
    }

    public boolean updateDescription(Lesson s, Integer i) {
        return lesson.updateDescription(s,i);
    }

    public boolean delete(Integer i) {
        return lesson.delete(i);
    }

    public boolean insert(Lesson s) {
        return lesson.insert(s);
    }
}

package main.services;

import main.model.pojo.Lesson;

import java.util.List;

/**
 * Created by Shoma on 19.04.2017.
 */
public interface LessonServiceInterface {
    List<Lesson> getAllLessons();
    boolean updateRoom(Lesson s, Integer i);
    boolean updateTime(Lesson s, Integer i);
    boolean updateDescription(Lesson s, Integer i);
    boolean delete(Integer i);
    boolean insert(Lesson s);
}

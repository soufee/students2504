package main.model.pojo;

import java.util.Date;

/**
 * Created by Shoma on 18.04.2017.
 */
public class Lesson {
    private int id;
    private int study_group_id;
    private Date lesson_date;
    private int room;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudy_group_id() {
        return study_group_id;
    }

    public void setStudy_group_id(int study_group_id) {
        this.study_group_id = study_group_id;
    }

    public Date getLesson_date() {
        return lesson_date;
    }

    public void setLesson_date(Date lesson_date) {
        this.lesson_date = lesson_date;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", study_group_id=" + study_group_id +
                ", lesson_date=" + lesson_date +
                ", room=" + room +
                ", description='" + description + '\'' +
                '}';
    }
}

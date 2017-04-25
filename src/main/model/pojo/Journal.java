package main.model.pojo;

/**
 * Created by Shoma on 18.04.2017.
 */
public class Journal {
    private int id;
    private int lesson_id;
    private int student_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLesson_id() {
        return lesson_id;
    }

    public void setLesson_id(int lesson_id) {
        this.lesson_id = lesson_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "id=" + id +
                ", lesson_id=" + lesson_id +
                ", student_id=" + student_id +
                '}';
    }
}

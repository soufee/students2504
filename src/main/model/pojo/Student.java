package main.model.pojo;

import main.controllers.listeners.MySessionListener;
import org.apache.log4j.Logger;

/**
 * Created by Shoma on 18.04.2017.
 */
public class Student {
   private int id;
   private String name;
   private int age;
   private int group_id;
    private static Logger LOGGER  = Logger.getLogger(MySessionListener.class);
    public Student(String name, int age, int group_id) {
        this.name = name;
        this.age = age;
        this.group_id = group_id;
        LOGGER.debug("Создан студент по имени "+name);
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", group_id=" + group_id +
                '}';
    }
}

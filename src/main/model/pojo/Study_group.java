package main.model.pojo;

/**
 * Created by Shoma on 18.04.2017.
 */
public class Study_group {
    private int id;
    private String name;

    public Study_group(String name) {
        this.name = name;
    }

    public Study_group() {

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

    @Override
    public String toString() {
        return "Study_group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

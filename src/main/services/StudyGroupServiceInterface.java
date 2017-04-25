package main.services;

import main.model.pojo.Study_group;

import java.util.List;

/**
 * Created by Shoma on 19.04.2017.
 */
public interface StudyGroupServiceInterface {
    List<Study_group> getAllGroups();
    boolean updateById(Study_group s, Integer i);
    boolean delete(Integer i);
    boolean insert(Study_group s);
}

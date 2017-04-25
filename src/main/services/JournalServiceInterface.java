package main.services;

import main.model.pojo.Journal;

import java.util.List;

/**
 * Created by Shoma on 19.04.2017.
 */
public interface JournalServiceInterface {
    List<Journal> getAllJournal();
    boolean updateById(Journal s, Integer i);
    boolean delete(Integer i);
    boolean insert(Journal s);
}

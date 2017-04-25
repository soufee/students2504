package main.model.dao;

import main.model.pojo.Journal;
import main.services.JournalServiceInterface;

import java.util.List;

/**
 * Created by Shoma on 18.04.2017.
 */
public class JournalDAO implements JournalServiceInterface{

    public List<Journal> getAllJournal() {
        return null;
    }

    public boolean updateById(Journal s, Integer i) {
        return false;
    }

    public boolean delete(Integer i) {
        return false;
    }

    public boolean insert(Journal s) {
        return false;
    }
}

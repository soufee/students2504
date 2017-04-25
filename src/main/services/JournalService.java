package main.services;

import main.model.dao.JournalDAO;
import main.model.pojo.Journal;

import java.util.List;

/**
 * Created by Shoma on 19.04.2017.
 */
public class JournalService implements JournalServiceInterface{
    public static JournalServiceInterface journal = new JournalDAO();
    public List<Journal> getAllJournal() {
        return journal.getAllJournal();
    }

    public boolean updateById(Journal s, Integer i) {
        return journal.updateById(s,i);
    }

    public boolean delete(Integer i) {
        return journal.delete(i);
    }

    public boolean insert(Journal s) {
        return journal.insert(s);
    }
}

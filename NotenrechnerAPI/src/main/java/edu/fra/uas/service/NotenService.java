package edu.fra.uas.service;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.fra.uas.model.Note;
import edu.fra.uas.repository.NotenRepository;


@Service
public class NotenService {

    private int nextNotenId=1;

    @Autowired
    private NotenRepository NotenRepository;

    public void createNote (Note Note) {
        Note.setId(nextNotenId++);
        NotenRepository.put(Note.getId(), Note);
    }

    public Note getNote (int id) {
        return NotenRepository.get(id);
    }

    public HashMap<Integer, Note> getAllNoten() {
        return NotenRepository;
    }

    public Note updateNote (Note Note) {
        return NotenRepository.put(Note.getId(), Note);
    }

    public Note deleteNote (Note Note) {
        return NotenRepository.remove(Note.getId());
    }

    public int getAnzahlNoten() {
        return NotenRepository.size();
    }

    public double getDurchschnitt(HashMap<Integer, Note> Notenliste) {
        double sum = 0;
        for (Note n : Notenliste.values()) {
            sum += n.getWert();
        }
        return sum / Notenliste.size();
    }

    public HashMap<Integer, Note> getNotenByName (String name) {
        HashMap<Integer, Note> Noten = new HashMap<>();
        for (Note n : NotenRepository.values()) {
            if (n.getNachname().equals(name)) {
                Noten.put(n.getId(), n);
            }
        }
        return Noten;
    }

    public HashMap<Integer, Note> getNotenByFach (String fach) {
        HashMap<Integer, Note> Noten = new HashMap<>();
        for (Note n : NotenRepository.values()) {
            if (n.getFach().equals(fach)) {
                Noten.put(n.getId(), n);
            }
        }
        return Noten;
    }

   





}

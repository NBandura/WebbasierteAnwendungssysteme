package NotenserviceWebAnwendung.Service;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import NotenserviceWebAnwendung.Model.Note;
import NotenserviceWebAnwendung.Repository.NotenRepository;

@Service
public class Notenservice {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(Notenservice.class);

    @Autowired
    private NotenRepository notenRepository;

    public void addNote(Note note) {
        log.info(note.getNote() + " wird abgespeichert");
        notenRepository.add(note);
    }

    public double getDurchschnitt() {
        log.info("Durchscnitt wird berechnet");
        double sum = 0;
        for (Note note : notenRepository) {
            log.info("Note abgerufen: " + note.getNote());
            sum += note.getNote();
        }
        return sum / notenRepository.size();
    }

}

package NotenserviceWebAnwendung.Model;
import org.slf4j.Logger;

public class Note {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(Note.class);

    private double note;


    public Note() {
        log.info("Note created");
    }

    public Note(int note) {
        this.note = note;
        log.info("Note created with note: " + note);
    }

    public double getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
        log.info("Note set to: " + note);
    }

}

package NotenserviceWebAnwendung.Controller;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import NotenserviceWebAnwendung.Model.Note;
import NotenserviceWebAnwendung.Service.Notenservice;
import org.springframework.ui.Model;

@Controller
public class NotenController {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(NotenController.class);


    @Autowired
    private Notenservice notenService;

    @RequestMapping
	public String get() {
        log.info("Startseite aufgerufen");
		return "index";
	}

    @RequestMapping(value = {"/add"}, method = RequestMethod.GET)
    public String add(@RequestParam("note") int noteWert,
    Model model)throws Exception {
        Note note = new Note(); 
        note.setNote(noteWert);
        notenService.addNote(note);
        model.addAttribute("note", note);
        return "add.html";
    }

    @RequestMapping(value = {"/durchschnitt"}, method = RequestMethod.GET)
    public String durchschnitt(Model model)throws Exception {
        double durchschnitt = notenService.getDurchschnitt();
        model.addAttribute("durchschnitt", durchschnitt);
        return "durchschnitt.html";
    }
}

package edu.fra.uas.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.fra.uas.Services.NotenService;

@Component
public class NotenController {

    @Autowired
    private NotenService notenService;

    public double addNote (double note) {
        return notenService.addNote (note);
    }

    public double getDurchschnitt() {
        return notenService.getDurchschnitt();
    }

    public double getNotenSumme() {
        return notenService.getNotenSumme();
    }

    public int getAnzahlNoten() {
        return notenService.getAnzahlNoten();
    }

}

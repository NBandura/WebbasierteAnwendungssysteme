package edu.fra.uas.Services;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class NotenService {
    private double notenSumme = 0;
    private int anzahlNoten = 0;
    private static final Logger log = LoggerFactory.getLogger(NotenService.class);

    public double addNote (double note) {
        this.notenSumme += note;
        this.anzahlNoten++;
        log.debug("Note hinzugefügt: " + note);
        return anzahlNoten;
    }

    public double getDurchschnitt() {
        log.debug("Durchschnitt berechnet: " + notenSumme / anzahlNoten);
        return notenSumme / anzahlNoten;
    }

    public double getNotenSumme() {
        log.debug("NotenSumme berechnet: " + notenSumme);
        return notenSumme;
    }

    public int getAnzahlNoten() {
        log.debug("AnzahlNoten berechnet: " + anzahlNoten);
        return anzahlNoten;
    }

    @PostConstruct
    public void PostConstruct() {
        log.debug("NotenService initialisiert");
    }

    @PreDestroy
    public void PreDestroy() {
        this.notenSumme = 0;
        this.anzahlNoten = 0;
        log.debug("NotenService beendet und daten Gelöscht");
    }


}

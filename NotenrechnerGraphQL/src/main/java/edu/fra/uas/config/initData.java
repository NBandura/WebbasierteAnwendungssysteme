package edu.fra.uas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.fra.uas.model.Note;
import edu.fra.uas.service.NotenService;
import jakarta.annotation.PostConstruct;

@Component
public class initData {

    @Autowired
    NotenService NotenService;

    @PostConstruct
    public void init(){
        Note Note = new Note();
        Note.setNachname("Mustermann");
        Note.setFach("Mathe");
        Note.setWert(1);
        NotenService.createNote (Note);

        Note = new Note();
        Note.setNachname("Bandura");
        Note.setFach("Mathe");
        Note.setWert(2);
        NotenService.createNote (Note);

        Note = new Note();
        Note.setNachname("Fleischer");
        Note.setFach("Mathe");
        Note.setWert(3);
        NotenService.createNote (Note);

    }


}

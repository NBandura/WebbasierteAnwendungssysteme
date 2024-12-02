package edu.fra.uas.controller;

import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;

import edu.fra.uas.model.Note;
import edu.fra.uas.service.NotenService;

@Controller
@SchemaMapping(typeName="Note")
public class GraphController {

    @Autowired
    private NotenService notenService;


    @QueryMapping(name="getAllNoten")
    public List<Note> getAllNoten() {
        Iterable<Note> NoteIter = notenService.getAllNoten();
        List<Note> Noten = new ArrayList<>();
        for (Note Note : NoteIter) {
            Noten.add(Note);
        }
        System.out.println(Noten);
        return Noten;
    }

    @QueryMapping(name="notenbyFach")
    public List<Note> getNotenByFach(@Argument String fach) {
        Iterable<Note> NoteIter = notenService.getNotenByFach(fach);
        List<Note> Noten = new ArrayList<>();
        for (Note Note : NoteIter) {
            Noten.add(Note);
        }
        return Noten;
    }

    @QueryMapping(name="notenbyNachname")
    public List<Note> getNotenByNachname(@Argument String nachname) {
        Iterable<Note> NoteIter = notenService.getNotenByName(nachname);
        List<Note> Noten = new ArrayList<>();
        for (Note Note : NoteIter) {
            Noten.add(Note);
        }
        return Noten;
    }

    @MutationMapping(name="addNote")
    public Note addNote(@Argument Long id, @Argument String nachname, @Argument String fach, @Argument int wert) {
        Note Note = new Note();
        Note.setId(id);
        Note.setNachname(nachname);
        Note.setFach(fach);
        Note.setWert(wert);
        notenService.createNote(Note);
        return Note;
    }

    @MutationMapping(name="deleteNote")
    public Long deleteNote(@Argument Long id) {
        Note Note = notenService.getNote(id);
        notenService.deleteNote(Note);
        return id;
    }

    
}

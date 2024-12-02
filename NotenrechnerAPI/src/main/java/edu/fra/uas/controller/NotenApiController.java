package edu.fra.uas.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import edu.fra.uas.model.Note;
import edu.fra.uas.service.NotenService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/api")
public class NotenApiController {
    @Autowired
    private NotenService NotenService;

    @GetMapping
    (value = "/noten", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<HashMap<Long,Note>> getNoten() {
        HashMap<Long,Note> Noten = NotenService.getAllNoten();
        if (Noten.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(Noten); 
        }
    }

    @GetMapping
    (value = "/noten/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<HashMap<Long,Note>> getNotenByName(@PathVariable("name") String name) {
        HashMap<Long,Note> Noten = NotenService.getNotenByName(name);
        if (Noten.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(Noten); 
        }
    }

    @GetMapping
    (value = "/noten/fach/{fach}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<HashMap<Long,Note>> getNotenByFach(@PathVariable("fach") String fach) {
        HashMap<Long,Note> Noten = NotenService.getNotenByFach(fach);
        if (Noten.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(Noten); 
        }
    }

    @GetMapping
    (value = "/noten/durchschnitt", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Double> getDurchschnitt() {
        double durchschnitt = NotenService.getDurchschnitt(NotenService.getAllNoten());
        return ResponseEntity.ok(durchschnitt);
    }

    @GetMapping
    (value = "/noten/durchschnitt/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Double> getDurchschnittByName(@PathVariable("name") String name) {
        double durchschnitt = NotenService.getDurchschnitt(NotenService.getNotenByName(name));
        return ResponseEntity.ok(durchschnitt);
    }

    @GetMapping
    (value = "/noten/durchschnitt/fach/{fach}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Double> getDurchschnittByFach(@PathVariable("fach") String fach) {
        double durchschnitt = NotenService.getDurchschnitt(NotenService.getNotenByFach(fach));
        return ResponseEntity.ok(durchschnitt);
    }

    @PostMapping 
    (value = "/noten/add",   produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> addNote(@RequestBody Note note) {
        System.out.println(note.getNachname());
        //Note tesNote=new Note(0, "mdawd", "adw", 2);
        NotenService.createNote(note);
        return ResponseEntity.ok(note);
    }


    @DeleteMapping
    (value = "/noten/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Note> deleteNote(@PathVariable("id") int id) {
        Note Note = NotenService.getNote(id);
        NotenService.deleteNote(Note);
        return ResponseEntity.ok(Note);
    }




    

    
    
    

}

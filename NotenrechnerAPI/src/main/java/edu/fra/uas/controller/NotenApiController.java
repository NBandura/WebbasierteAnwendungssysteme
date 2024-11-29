package edu.fra.uas.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
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
    (value = "/Noten", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<HashMap<Integer,Note>> getNoten() {
        HashMap<Integer,Note> Noten = NotenService.getAllNoten();
        if (Noten.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(Noten); 
        }
    }

    @GetMapping
    (value = "/Noten/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<HashMap<Integer,Note>> getNotenByName(@PathVariable("name") String name) {
        HashMap<Integer,Note> Noten = NotenService.getNotenByName(name);
        if (Noten.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(Noten); 
        }
    }

    @GetMapping
    (value = "/Noten/fach/{fach}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<HashMap<Integer,Note>> getNotenByFach(@PathVariable("fach") String fach) {
        HashMap<Integer,Note> Noten = NotenService.getNotenByFach(fach);
        if (Noten.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(Noten); 
        }
    }

    @GetMapping
    (value = "/Noten/durchschnitt", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Double> getDurchschnitt() {
        double durchschnitt = NotenService.getDurchschnitt(NotenService.getAllNoten());
        return ResponseEntity.ok(durchschnitt);
    }

    @GetMapping
    (value = "/Noten/durchschnitt/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Double> getDurchschnittByName(@PathVariable("name") String name) {
        double durchschnitt = NotenService.getDurchschnitt(NotenService.getNotenByName(name));
        return ResponseEntity.ok(durchschnitt);
    }

    @GetMapping
    (value = "/Noten/durchschnitt/fach/{fach}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Double> getDurchschnittByFach(@PathVariable("fach") String fach) {
        double durchschnitt = NotenService.getDurchschnitt(NotenService.getNotenByFach(fach));
        return ResponseEntity.ok(durchschnitt);
    }

    @PostMapping
    (value = "/Noten/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> addNote(@RequestBody Note NeueNote) {
        System.out.println(NeueNote.getNachname());
        NotenService.createNote(NeueNote);
        return ResponseEntity.ok(NeueNote);
    }

    @DeleteMapping
    (value = "/Noten/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Note> deleteNote(@PathVariable("id") int id) {
        Note Note = NotenService.getNote(id);
        NotenService.deleteNote(Note);
        return ResponseEntity.ok(Note);
    }



    

    
    
    

}

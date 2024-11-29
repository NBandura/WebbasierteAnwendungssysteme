package edu.fra.uas.model;

public class Note {


    private int id;
    private String nachname;
    private String fach;
    private int wert;

    public Note() {
    }

    public Note(int id,String nachname, String fach, int wert) {
        this.id = id;
        this.nachname = nachname;
        this.fach = fach;
        this.wert = wert;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getFach() {
        return fach;
    }

    public void setFach(String fach) {
        this.fach = fach;
    }

    public int getWert() {
        return wert;
    }

    public void setWert(int wert) {
        this.wert = wert;
    }

    




}

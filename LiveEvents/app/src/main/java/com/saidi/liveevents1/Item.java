package com.saidi.liveevents1;

import java.util.Date;

public class Item {
    String Groupe;
    String Scene;
    String dateconcert;
    String heure;

    int image;

    public Item(String groupe, String scene, String dateconcert, String heure, int image) {
        Groupe = groupe;
        Scene = scene;
        this.dateconcert = dateconcert;
        this.heure = heure;
        this.image = image;
    }

    public String getGroupe() {
        return Groupe;
    }

    public void setGroupe(String groupe) {
        Groupe = groupe;
    }

    public String getScene() {
        return Scene;
    }

    public void setScene(String scene) {
        Scene = scene;
    }

    public String getDateconcert() {
        return dateconcert;
    }

    public void setDateconcert(String dateconcert) {
        this.dateconcert = dateconcert;
    }

    public String getHeure() {
        return heure;
    }
    public int getImage() {
        return image;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

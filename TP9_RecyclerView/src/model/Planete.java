package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Planete implements Serializable {
    private String nom;
    private int distance; // en millions de km
    private String periodeRevolution; // en jours ou années
    private String diametre; // en kilomètres
    private String gravite; // gravité relative à celle de la Terre
    private int nombreSatellites; // nombre de lunes
    private int image; // image de planete

    public Planete(String nom, int distance,int image, String periodeRevolution, String diametre, String gravite, int nombreSatellites) {
        this.nom = nom;
        this.distance = distance;
        this.image=image;
        this.periodeRevolution = periodeRevolution;
        this.diametre = diametre;
        this.gravite = gravite;
        this.nombreSatellites = nombreSatellites;
    }

    public String getNom() {
        return nom;
    }

    public int getDistance() {
        return distance;
    }

    public String getPeriodeRevolution() {
        return periodeRevolution;
    }

    public String getDiametre() {
        return diametre;
    }

    public String getGravite() {
        return gravite;
    }

    public int getNombreSatellites() {
        return nombreSatellites;
    }

    public int getImage() {
        return image;
    }
}

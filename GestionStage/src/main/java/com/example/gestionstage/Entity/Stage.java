package com.example.gestionstage.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Stage implements Serializable {
    private static final long serialVersionUID = 6;
    @Id
    @GeneratedValue
    private int id;
    private String titre; // Titre du stage
    private String description; // Description du stage
    private String lieu; // Lieu du stage
    private String duree; // Durée du stage
    private Date datedebut;

    public Stage() {
    }


    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Stage(String titre, String description, String lieu, String duree, Date datedebut) {
        this.titre = titre;
        this.description = description;
        this.lieu = lieu;
        this.duree = duree;
        this.datedebut = datedebut;
    }


}

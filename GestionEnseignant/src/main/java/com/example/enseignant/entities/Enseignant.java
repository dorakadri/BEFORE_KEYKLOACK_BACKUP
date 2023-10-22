package com.example.enseignant.entities;

import com.fasterxml.jackson.annotation.JsonCreator;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "enseignant")
public class Enseignant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private int idEns;
private  String nom;
private  String prenom;
private  int numTel;

    @JsonCreator

    public Enseignant(String nom) {
        this.idEns = idEns;
        this.nom = nom;
        this.prenom = prenom;
        this.numTel = numTel;
    }

    public int getIdEns() {
        return idEns;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getNumTel() {
        return numTel;
    }

    public void setIdEns(int idEns) {
        this.idEns = idEns;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNumTel(int numTel) {
        this.numTel = numTel;
    }

    @Override
    public String toString() {
        return "Enseignant{" +
                "idEns=" + idEns +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", numTel=" + numTel +
                '}';
    }

    public Enseignant() {
    }
}

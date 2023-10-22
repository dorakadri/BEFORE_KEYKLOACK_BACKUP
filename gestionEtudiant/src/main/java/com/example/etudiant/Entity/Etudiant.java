package com.example.etudiant.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Etudiant implements Serializable {
    private static final long serialVersionUID = 6;

    @Id
    @GeneratedValue
    private int id;
    private String nom, prenom, email;
    private Date datenaissance;
    private String adresse;
    private String cin;
    private String numtelephone;

    public Etudiant() {

    }

    // Getter and Setter methods for datenaissance
    public Date getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }

    // Getter and Setter methods for adresse
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    // Getter and Setter methods for cin
    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    // Getter and Setter methods for numtelephone
    public String getNumtelephone() {
        return numtelephone;
    }

    public void setNumtelephone(String numtelephone) {
        this.numtelephone = numtelephone;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Etudiant(String nom, String prenom, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    public Etudiant(String nom, String prenom, String email, Date datenaissance, String adresse, String cin, String numtelephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.datenaissance = datenaissance;
        this.adresse = adresse;
        this.cin = cin;
        this.numtelephone = numtelephone;
    }
}

package com.example.gestiondescours.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Courses implements Serializable {
    private static final long serialVersionUID = 6;

    @Id
    @GeneratedValue

    private int id;
    private String nom ,description ;
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date ;

    @Temporal(TemporalType.TIMESTAMP)
    private Date time ;


    @Enumerated(EnumType.ORDINAL)
    private Format format ;

    @Enumerated(EnumType.ORDINAL)
    private Niveau niveau ;


    public Courses() {
    }

    public Courses(String nom, String description, Date date, Date time, Format format, Niveau niveau) {

        this.nom = nom;
        this.description = description;
        this.date = date;
        this.time = time;
        this.format = format;
        this.niveau = niveau;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }


    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public Date getTime() {
        return time;
    }

    public Format getFormat() {
        return format;
    }

    public Niveau getNiveau() {
        return niveau;
    }
}
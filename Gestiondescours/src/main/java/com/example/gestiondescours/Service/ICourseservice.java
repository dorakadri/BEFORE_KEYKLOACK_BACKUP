package com.example.gestiondescours.Service;

import com.example.gestiondescours.Entity.Courses;
import com.example.gestiondescours.Entity.Format;
import com.example.gestiondescours.Entity.Niveau;

import java.util.Date;
import java.util.List;

public interface ICourseservice {

    public Courses addCourses(Courses Courses) ;
    public List<Courses> getallCourses() ;
    public Courses updateCourse(int id, Courses newcourse) ;

    public String deleteCourses(int id) ;
    public List<Courses> getCoursesByNiveau(Niveau niveau);

    public List<Courses> getCoursesByFormat(Format Format);

    public   Courses findCoursesByNom(String nom);
    public    List<Courses> findByDateBetween(Date startDate, Date endDate);
}
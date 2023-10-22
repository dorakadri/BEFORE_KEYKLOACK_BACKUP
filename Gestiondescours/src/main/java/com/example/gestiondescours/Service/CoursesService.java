package com.example.gestiondescours.Service;

import com.example.gestiondescours.Entity.Courses;
import com.example.gestiondescours.Entity.Format;
import com.example.gestiondescours.Entity.Niveau;
import com.example.gestiondescours.Repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CoursesService implements ICourseservice {
    @Autowired
    private CoursesRepository coursesRepository;



    public Courses addCourses(Courses Courses)
    { return coursesRepository.save(Courses); }

    public List<Courses> getallCourses()
    { return coursesRepository.findAll() ; }
    public Courses updateCourse(int id, Courses newcourse) {
        System.out.println(newcourse.toString());
        if (coursesRepository.findById(id).isPresent())
        { Courses oldcourse = coursesRepository.findById(id).get();
            oldcourse.setNom(newcourse.getNom());
            oldcourse.setDescription(newcourse.getDescription());
            oldcourse.setDate(newcourse.getDate());
            oldcourse.setTime(newcourse.getTime());
            oldcourse.setNiveau(newcourse.getNiveau());
            oldcourse.setFormat(newcourse.getFormat());
            return coursesRepository.save(oldcourse); }
        else return null; }

    public String deleteCourses(int id) {
        if (coursesRepository.findById(id).isPresent())
        { coursesRepository.deleteById(id); return "Courses supprimé"; }
        else return "Courses non supprimé";
    }
    public List<Courses> getCoursesByNiveau(Niveau niveau) {
        return coursesRepository.findCoursesByNiveau(niveau);
    }

    @Override
    public Courses getCourseByid(int id) {
        return coursesRepository.findById(id).get();
    }

    @Override
    public List<Courses> getCoursesByFormat(Format Format) {
        return coursesRepository.findCoursesByFormat(Format);
    }

    @Override
    public Courses findCoursesByNom(String nom) {
        return coursesRepository.findCoursesByNom(nom) ;
    }

    @Override
    public List<Courses> findByDateBetween(Date startDate, Date endDate) {
        return coursesRepository.findByDateBetween(startDate,endDate) ;
    }


}
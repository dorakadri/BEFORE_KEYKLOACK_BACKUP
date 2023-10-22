package com.example.gestiondescours.Controller;


import com.example.gestiondescours.Entity.Courses;
import com.example.gestiondescours.Entity.Format;
import com.example.gestiondescours.Entity.Niveau;
import com.example.gestiondescours.Service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value="/api/cours")
public class CoursesController {


    private final CoursesService coursesService;

    @Autowired
    public CoursesController(CoursesService coursesService) {
        this.coursesService = coursesService;
    }

    @PostMapping
    public Courses addCourses(@RequestBody Courses courses) {
        return coursesService.addCourses(courses);
    }

    @GetMapping
    public List<Courses> getAllCourses() {
        return coursesService.getallCourses();
    }

    @PutMapping("/{id}")
    public Courses updateCourse(@PathVariable int id, @RequestBody Courses newcourse) {
        return coursesService.updateCourse(id, newcourse);
    }

    @DeleteMapping("/{id}")
    public String deleteCourses(@PathVariable int id) {
        return coursesService.deleteCourses(id);
    }

    @GetMapping("/by-niveau/{niveau}")
    public List<Courses> getCoursesByNiveau(@PathVariable Niveau niveau) {
        return coursesService.getCoursesByNiveau(niveau);
    }
    @GetMapping("{id}")
    public Courses getCoursesByID(@PathVariable int id) {
        return coursesService.getCourseByid(id);
    }

    @GetMapping("/by-Format/{Format}")
    public List<Courses> getCoursesByFormat(@PathVariable Format Format){
        return coursesService.getCoursesByFormat(Format) ;
    }
    @GetMapping("/by-Nom/{nom}")
    public   Courses findCoursesByNom(@PathVariable String nom){
        return coursesService.findCoursesByNom(nom) ;
    }
    @GetMapping("/by-DateBetween/{startDate}/{endDate}")
    public    List<Courses> findByDateBetween(@PathVariable Date startDate, @PathVariable Date endDate){

        return coursesService.findByDateBetween(startDate,endDate) ;
    }


}
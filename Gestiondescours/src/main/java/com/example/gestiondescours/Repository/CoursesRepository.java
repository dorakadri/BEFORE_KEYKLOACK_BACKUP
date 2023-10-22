package com.example.gestiondescours.Repository;


import com.example.gestiondescours.Entity.Courses;
import com.example.gestiondescours.Entity.Format;
import com.example.gestiondescours.Entity.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CoursesRepository  extends JpaRepository<Courses, Integer> {
    @Query("SELECT c FROM Courses c WHERE c.niveau = :niveau")
    List<Courses> findCoursesByNiveau(@Param("niveau") Niveau niveau);

    @Query("SELECT c FROM Courses c WHERE c.format = :format")
    List<Courses> findCoursesByFormat(@Param("format") Format format);

    Courses findCoursesByNom(String nom);

    List<Courses> findByDateBetween(Date startDate, Date endDate);

}
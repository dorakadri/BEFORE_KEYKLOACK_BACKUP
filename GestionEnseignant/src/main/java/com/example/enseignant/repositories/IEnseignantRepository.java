package com.example.enseignant.repositories;

import com.example.enseignant.entities.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEnseignantRepository extends JpaRepository<Enseignant, Integer> {
}

package com.example.gestionstage.Repository;

import com.example.gestionstage.Entity.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StageRepoitory extends JpaRepository<Stage, Integer> {
}

package com.example.etudiant.Repository;


import com.example.etudiant.Entity.Etudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository. Query;
import org.springframework.data.repository. query. Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {
    @Query("SELECT e FROM Etudiant e WHERE e.nom LIKE %:name%")
    public Page<Etudiant> findEtudiantsByName(@Param("name") String name, Pageable pageable);
}
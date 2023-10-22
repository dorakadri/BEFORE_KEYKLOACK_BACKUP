package com.example.etudiant.Service;

import com.example.etudiant.Entity.Etudiant;
import com.example.etudiant.Repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService {
    @Autowired
    private EtudiantRepository etudiantRepository;


    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }
    public Etudiant addEtudiant(Etudiant candidate) {
        return etudiantRepository.save(candidate);
    }

    public Etudiant updateEtudiant(int id, Etudiant newEtudiant) {
        Optional<Etudiant> existingEtudiantOptional = etudiantRepository.findById(id);
        if (existingEtudiantOptional.isPresent()) {
            Etudiant existingEtudiant = existingEtudiantOptional.get();

            if (newEtudiant.getNom() != null) {
                existingEtudiant.setNom(newEtudiant.getNom());
            }
            if (newEtudiant.getPrenom() != null) {
                existingEtudiant.setPrenom(newEtudiant.getPrenom());
            }
            if (newEtudiant.getEmail() != null) {
                existingEtudiant.setEmail(newEtudiant.getEmail());
            }
            if (newEtudiant.getDatenaissance() != null) {
                existingEtudiant.setDatenaissance(newEtudiant.getDatenaissance());
            }
            if (newEtudiant.getAdresse() != null) {
                existingEtudiant.setAdresse(newEtudiant.getAdresse());
            }
            if (newEtudiant.getCin() != null) {
                existingEtudiant.setCin(newEtudiant.getCin());
            }
            if (newEtudiant.getNumtelephone() != null) {
                existingEtudiant.setNumtelephone(newEtudiant.getNumtelephone());
            }

            return etudiantRepository.save(existingEtudiant);
        } else {
            return null;
        }
    }


    public String deleteEtudiant(int id) {
        if (etudiantRepository.findById(id).isPresent()) {
            etudiantRepository.deleteById(id);
            return "Étudiant supprimé";
        } else {
            return "Étudiant non supprimé";
        }
    }

    public Page<Etudiant> searchEtudiantsByName(String name, Pageable pageable) {
        return etudiantRepository.findEtudiantsByName(name, pageable);
    }
}

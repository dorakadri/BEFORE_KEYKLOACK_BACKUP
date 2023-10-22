package com.example.enseignant.Service;

import com.example.enseignant.entities.Enseignant;
import com.example.enseignant.repositories.IEnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnseignantService {

    @Autowired
    private IEnseignantRepository enseignantRepository;

    public List<Enseignant> getAllEnseignants() {
        return enseignantRepository.findAll();
    }

    public Enseignant addEnseignant(Enseignant enseignant)
    {
        return enseignantRepository.save(enseignant);
    }



    public Enseignant updateEnseignant(int id, Enseignant newEnseignant) {
        if (enseignantRepository.findById(id).isPresent())
        { Enseignant existingEnseignant = enseignantRepository.findById(id).get();
            existingEnseignant.setNom(newEnseignant.getNom());
            existingEnseignant.getNom();
            return enseignantRepository.save(existingEnseignant); }
        else return null; }

    public String deleteEnseignant(int id) {
        if (enseignantRepository.findById(id).isPresent())
        { enseignantRepository.deleteById(id); return "Enseignant supprimé"; }
        else return "Enseignant non supprimé";
    }
    public Page<Enseignant> searchEnseignantsByName(String nom, Pageable pageable) {
        return enseignantRepository.findEnseignantsByName(nom, pageable);
    }
}

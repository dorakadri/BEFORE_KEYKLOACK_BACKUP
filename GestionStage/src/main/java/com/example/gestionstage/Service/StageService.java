package com.example.gestionstage.Service;

import com.example.gestionstage.Repository.StageRepoitory;
import com.example.gestionstage.Entity.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StageService {
    @Autowired
    private StageRepoitory stageRepoitory;

    public List<Stage> getAllStages() {
        return stageRepoitory.findAll();
    }
    public Stage addStage(Stage stage) {
        return stageRepoitory.save(stage);
    }

    public Stage updateStage(int id, Stage newStage) {
        Optional<Stage> existingStageOptional = stageRepoitory.findById(id);
        if (existingStageOptional.isPresent()) {
            Stage existingStage = existingStageOptional.get();

            if (newStage.getTitre() != null) {
                existingStage.setTitre(newStage.getTitre());
            }
            if (newStage.getDescription() != null) {
                existingStage.setDescription(newStage.getDescription());
            }
            if (newStage.getDatedebut() != null) {
                existingStage.setDatedebut(newStage.getDatedebut());
            }
            if (newStage.getDuree() != null) {
                existingStage.setDuree(newStage.getDuree());
            }
            if (newStage.getLieu() != null) {
                existingStage.setLieu(newStage.getLieu());
            }


            return stageRepoitory.save(existingStage);
        } else {
            return null;
        }
    }


    public String deleteStage(int id) {
        if (stageRepoitory.findById(id).isPresent()) {
            stageRepoitory.deleteById(id);
            return "stage supprimé";
        } else {
            return "stage non supprimé";
        }
    }

    public Stage searchStage(int id) {
       return stageRepoitory.findById(id).orElse(null);
    }
}

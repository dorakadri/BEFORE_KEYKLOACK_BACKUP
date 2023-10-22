package com.example.gestionstage.Controller;

import com.example.gestionstage.Entity.Stage;
import com.example.gestionstage.Service.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/stages")
public class StageRestApi {

    @Autowired
    private StageService stageService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Stage>> getAllStages() {
        List<Stage> stages = stageService.getAllStages();
        return new ResponseEntity<>(stages, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Stage> createStage(@RequestBody Stage stage) {
        return new ResponseEntity<>(stageService.addStage(stage), HttpStatus.OK);
    }


    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE) @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Stage> updateStage(@PathVariable(value = "id") int id,
                                                   @RequestBody Stage stage){
        return new ResponseEntity<>(stageService.updateStage(id, stage), HttpStatus.OK);
    }



    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE) @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteStage(@PathVariable(value = "id") int id){
        return new ResponseEntity<>(stageService.deleteStage(id), HttpStatus.OK); }



    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Stage> searchStage(
            @RequestParam(value = "id") int id

    ) {

        Stage stage = stageService.searchStage(id);
        return new ResponseEntity<>(stage, HttpStatus.OK);
    }



}

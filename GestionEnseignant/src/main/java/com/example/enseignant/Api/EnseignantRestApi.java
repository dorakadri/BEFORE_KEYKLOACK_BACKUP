package com.example.enseignant.Api;

import com.example.enseignant.Service.EnseignantService;
import com.example.enseignant.entities.Enseignant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/enseignants")
public class EnseignantRestApi {

    @Autowired
    private EnseignantService EnseignantService;

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Enseignant> addEnseignant(@RequestBody  Enseignant enseignant)
    { return new ResponseEntity<>(EnseignantService.addEnseignant(enseignant), HttpStatus.OK); }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE) @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Enseignant> updateEnseignant(@PathVariable(value = "id") int id,
                                         @RequestBody Enseignant enseignant){
        return new ResponseEntity<>(EnseignantService.updateEnseignant(id, enseignant), HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE) @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteEnseignant(@PathVariable(value = "id") int id){
        return new ResponseEntity<>(EnseignantService.deleteEnseignant(id), HttpStatus.OK); }


}

package com.example.etudiant.Controller;



import com.example.etudiant.Entity.Etudiant;
import com.example.etudiant.Service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/etudiants")
public class EtudiantRestApi {
    @Autowired
    private EtudiantService etudiantService;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Etudiant>> getAllEtudiants() {
        List<Etudiant> etudiants = etudiantService.getAllEtudiants();
        return new ResponseEntity<>(etudiants, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Etudiant> createEtudiant(@RequestBody Etudiant etudiant) {
        return new ResponseEntity<>(etudiantService.addEtudiant(etudiant), HttpStatus.OK);
    }


    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE) @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Etudiant> updateEtudiant(@PathVariable(value = "id") int id,
                                                   @RequestBody Etudiant etudiant){
        return new ResponseEntity<>(etudiantService.updateEtudiant(id, etudiant), HttpStatus.OK);
    }



    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE) @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteEtudiant(@PathVariable(value = "id") int id){
        return new ResponseEntity<>(etudiantService.deleteEtudiant(id), HttpStatus.OK); }



    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Page<Etudiant>> searchEtudiantsByName(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Etudiant> etudiants = etudiantService.searchEtudiantsByName(name, pageRequest);
        return new ResponseEntity<>(etudiants, HttpStatus.OK);
    }

}



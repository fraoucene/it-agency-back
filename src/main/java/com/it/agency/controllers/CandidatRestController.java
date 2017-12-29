package com.it.agency.controllers;

import com.it.agency.beans.Candidat;
import com.it.agency.repositories.CandidatRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Collection;

@RestController
@RequestMapping("/api/candidats")
//@CrossOrigin(origins = {"*"}, exposedHeaders = "Access-Control-Expose-Headers: X-Total-Count", allowedHeaders = "Access-Control-Expose-Headers: X-Total-Count")
public class CandidatRestController {

    private CandidatRepo repository;

    @Inject
    public void setRepository(CandidatRepo repository) {
        this.repository = repository;
    }

    @RequestMapping(
            method = RequestMethod.POST)
    public ResponseEntity<?> addCandidat(@RequestBody Candidat candidat) {
        return new ResponseEntity<>(repository.save(candidat), HttpStatus.CREATED);
    }

    @RequestMapping(
            method = RequestMethod.GET)
    public ResponseEntity<Collection<Candidat>> getAllCandidats() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<Candidat> getCandidatWithId(@PathVariable Long id) {
        return new ResponseEntity<>(repository.findOne(id), HttpStatus.OK);
    }

    @RequestMapping(
            params = {"id"},
            method = RequestMethod.GET)
    public ResponseEntity<Candidat> findCandidatWithId(@RequestParam(value = "id") Long id) {
        return new ResponseEntity<>(repository.findById(id), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public ResponseEntity<Candidat> updateCandidatFromDB(@PathVariable("id") Long id, @RequestBody Candidat candidat) {

        Candidat currentCandidat = repository.findOne(id);
        currentCandidat.setNom(candidat.getNom());
        currentCandidat.setPrenom(candidat.getPrenom());
        currentCandidat.setPoste(candidat.getPoste());
        currentCandidat.setPhone(candidat.getPhone());
        currentCandidat.setEmail(candidat.getEmail());

        return new ResponseEntity<>(repository.save(currentCandidat), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public void deleteCandidatWithId(@PathVariable Long id) {
        repository.delete(id);
    }

    @RequestMapping(
            method = RequestMethod.DELETE)
    public void deleteAllCandidat() {
        repository.deleteAll();
    }
}

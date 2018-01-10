package com.it.agency.controllers;

import com.it.agency.beans.Recrut;
import com.it.agency.repositories.RecrutRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Collection;

@RestController
@RequestMapping("/api/recruts")
public class RecrutRestController {

    private RecrutRepo repository;

    @Inject
    public void setRepository(RecrutRepo repository) {
        this.repository = repository;
    }

    @RequestMapping(
            method = RequestMethod.POST)
    public ResponseEntity<?> addRecrut(@RequestBody Recrut recrut) {
        return new ResponseEntity<>(repository.save(recrut), HttpStatus.CREATED);
    }

    @RequestMapping(
            method = RequestMethod.GET)
    public ResponseEntity<Collection<Recrut>> getAllRecruts() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<Recrut> getRecrutWithId(@PathVariable Long id) {
        return new ResponseEntity<>(repository.findOne(id), HttpStatus.OK);
    }

    @RequestMapping(
            params = {"id"},
            method = RequestMethod.GET)
    public ResponseEntity<Recrut> findRecrutWithId(@RequestParam(value = "id") Long id) {
        return new ResponseEntity<>(repository.findById(id), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public ResponseEntity<Recrut> updateRecrutFromDB(@PathVariable("id") Long id, @RequestBody Recrut recrut) {

        Recrut currentRecrut = repository.findOne(id);
        currentRecrut.setSociete(recrut.getSociete());
        currentRecrut.setNom(recrut.getNom());
        currentRecrut.setPrenom(recrut.getPrenom());
        currentRecrut.setPoste(recrut.getPoste());
        currentRecrut.setPhone(recrut.getPhone());
        currentRecrut.setEmail(recrut.getEmail());
        currentRecrut.setMessage(recrut.getMessage());

        return new ResponseEntity<>(repository.save(currentRecrut), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public void deleteRecrutWithId(@PathVariable Long id) {
        repository.delete(id);
    }

    @RequestMapping(
            method = RequestMethod.DELETE)
    public void deleteAllRecrut() {
        repository.deleteAll();
    }
}

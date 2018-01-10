package com.it.agency.controllers;

import com.it.agency.beans.Information;
import com.it.agency.repositories.InformationRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Collection;

@RestController
@RequestMapping("/api/informations")
public class InformationRestController {

    private InformationRepo repository;

    @Inject
    public void setRepository(InformationRepo repository) {
        this.repository = repository;
    }

    @RequestMapping(
            method = RequestMethod.POST)
    public ResponseEntity<?> addInformation(@RequestBody Information information) {
        return new ResponseEntity<>(repository.save(information), HttpStatus.CREATED);
    }

    @RequestMapping(
            method = RequestMethod.GET)
    public ResponseEntity<Collection<Information>> getAllInformations() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<Information> getInformationWithId(@PathVariable Long id) {
        return new ResponseEntity<>(repository.findOne(id), HttpStatus.OK);
    }

    @RequestMapping(
            params = {"id"},
            method = RequestMethod.GET)
    public ResponseEntity<Information> findInformationWithId(@RequestParam(value = "id") Long id) {
        return new ResponseEntity<>(repository.findById(id), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public ResponseEntity<Information> updateInformationFromDB(@PathVariable("id") Long id, @RequestBody Information information) {

        Information currentInformation = repository.findOne(id);
        currentInformation.setNom(information.getNom());
        currentInformation.setPrenom(information.getPrenom());
        currentInformation.setPhone(information.getPhone());
        currentInformation.setEmail(information.getEmail());
        currentInformation.setMessage(information.getMessage());

        return new ResponseEntity<>(repository.save(currentInformation), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public void deleteInformationWithId(@PathVariable Long id) {
        repository.delete(id);
    }

    @RequestMapping(
            method = RequestMethod.DELETE)
    public void deleteAllInformation() {
        repository.deleteAll();
    }
}

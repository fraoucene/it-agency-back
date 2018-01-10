package com.it.agency.controllers;

import com.it.agency.beans.Offre;
import com.it.agency.repositories.OffreRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Collection;

@RestController
@RequestMapping("/api/offres")
public class OffreRestController {

    private OffreRepo repository;

    @Inject
    public void setRepository(OffreRepo repository) {
        this.repository = repository;
    }

    @RequestMapping(
            method = RequestMethod.POST)
    public ResponseEntity<?> addOffre(@RequestBody Offre offre) {
        return new ResponseEntity<>(repository.save(offre), HttpStatus.CREATED);
    }

    @RequestMapping(
            method = RequestMethod.GET)
    public ResponseEntity<Collection<Offre>> getAllOffres() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<Offre> getOffreWithId(@PathVariable Long id) {
        return new ResponseEntity<>(repository.findOne(id), HttpStatus.OK);
    }

    @RequestMapping(
            params = {"id"},
            method = RequestMethod.GET)
    public ResponseEntity<Offre> findOffreWithId(@RequestParam(value = "id") Long id) {
        return new ResponseEntity<>(repository.findById(id), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public ResponseEntity<Offre> updateOffreFromDB(@PathVariable("id") Long id, @RequestBody Offre offre) {

        Offre currentOffre = repository.findOne(id);
        currentOffre.setTitle(offre.getTitle());
        currentOffre.setSubtitle(offre.getSubtitle());
        currentOffre.setResume(offre.getResume());
        currentOffre.setDetail(offre.getDetail());

        return new ResponseEntity<>(repository.save(currentOffre), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public void deleteOffreWithId(@PathVariable Long id) {
        repository.delete(id);
    }

    @RequestMapping(
            method = RequestMethod.DELETE)
    public void deleteAllOffre() {
        repository.deleteAll();
    }
}

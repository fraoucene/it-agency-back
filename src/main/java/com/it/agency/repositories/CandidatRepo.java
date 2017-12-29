package com.it.agency.repositories;

import com.it.agency.beans.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CandidatRepo extends JpaRepository<Candidat, Long> {
    Candidat findById(Long id);
}

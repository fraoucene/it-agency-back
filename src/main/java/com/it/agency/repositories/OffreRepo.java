package com.it.agency.repositories;

import com.it.agency.beans.Offre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OffreRepo extends JpaRepository<Offre, Long> {
    Offre findById(Long id);
}

package com.it.agency.repositories;

import com.it.agency.beans.Information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface InformationRepo extends JpaRepository<Information, Long> {
    Information findById(Long id);
}

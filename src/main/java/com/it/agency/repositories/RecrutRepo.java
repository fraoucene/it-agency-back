package com.it.agency.repositories;

import com.it.agency.beans.Recrut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RecrutRepo extends JpaRepository<Recrut, Long> {
    Recrut findById(Long id);
}

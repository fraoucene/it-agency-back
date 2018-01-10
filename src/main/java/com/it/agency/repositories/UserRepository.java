package com.it.agency.repositories;

import com.it.agency.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(" select u from User u " +
            " where u.name = ?1")
    Optional<User> findUserWithName(String name);

}
package com.awsquickstarts.testrdsmysqljava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.awsquickstarts.testrdsmysqljava.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {
    
}

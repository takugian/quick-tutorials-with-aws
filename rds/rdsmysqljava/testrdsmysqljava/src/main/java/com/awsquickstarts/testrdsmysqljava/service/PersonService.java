package com.awsquickstarts.testrdsmysqljava.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awsquickstarts.testrdsmysqljava.model.Person;
import com.awsquickstarts.testrdsmysqljava.repository.PersonRepository;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @PostConstruct
    public void init() {

        System.out.println("Running init");

        System.out.println("Running findAll");
        List<Person> people = findAll();
        System.out.println("findAll has completed");
        System.out.println("Number of people saved: " + people.size());

        System.out.println("Running save");
        Person person = new Person("678.112.908-20", "RICADO DA COSTA SILVA", "MALE", 31);
        person = save(person);
        System.out.println("save has completed");
        System.out.println("Number of people saved: " + findAll().size());

        System.out.println("Running deleteById");
        deleteById(person.getPersonDocumentNumber());
        System.out.println("deleteById has completed");
        System.out.println("Number of people: " + findAll().size());

        System.out.println("init has completed");

    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person save(final Person person) {

        if (person.getPersonDocumentNumber() == null || person.getPersonDocumentNumber().length() == 0) {
            throw new IllegalArgumentException("person_document_number is required");
        } else if (person.getPersonName() == null || person.getPersonName().length() == 0) {
            throw new IllegalArgumentException("person_name is required");
        }

        return this.personRepository.save(person);

    }

    public void deleteById(final String personDocumentNumber) {
        this.personRepository.deleteById(personDocumentNumber);
    }

}

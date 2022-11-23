package com.awsquickstarts.testrdsmysqljava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.awsquickstarts.testrdsmysqljava.service.PersonService;

@SpringBootApplication
public class TestrdsmysqljavaApplication {

	@Autowired
	private PersonService personService;

	public static void main(String[] args) {
		SpringApplication.run(TestrdsmysqljavaApplication.class, args);
	}

	public PersonService getPersonService() {
		return personService;
	}

}

package com.awsquickstarts.testrdsmysqljava.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_person")
public class Person {

    @Id
    @Column(name = "person_document_number", nullable = false)
    private String personDocumentNumber;

    @Column(name = "person_name", nullable = false)
    private String personName;

    @Column(name = "person_gender", nullable = true)
    private String personGender;

    @Column(name = "person_age", nullable = false)
    private Integer personAge;

    public Person() {
    }

    public Person(String personDocumentNumber, String personName, String personGender, Integer personAge) {
        this.personDocumentNumber = personDocumentNumber;
        this.personName = personName;
        this.personGender = personGender;
        this.personAge = personAge;
    }

    public String getPersonDocumentNumber() {
        return this.personDocumentNumber;
    }

    public void setPersonDocumentNumber(String personDocumentNumber) {
        this.personDocumentNumber = personDocumentNumber;
    }

    public String getPersonName() {
        return this.personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonGender() {
        return this.personGender;
    }

    public void setPersonGender(String personGender) {
        this.personGender = personGender;
    }

    public Integer getPersonAge() {
        return this.personAge;
    }

    public void setPersonAge(Integer personAge) {
        this.personAge = personAge;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Person)) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(personDocumentNumber, person.personDocumentNumber)
                && Objects.equals(personName, person.personName) && Objects.equals(personGender, person.personGender)
                && Objects.equals(personAge, person.personAge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personDocumentNumber, personName, personGender, personAge);
    }

    @Override
    public String toString() {
        return "{" +
                " personDocumentNumber='" + getPersonDocumentNumber() + "'" +
                ", personName='" + getPersonName() + "'" +
                ", personGender='" + getPersonGender() + "'" +
                ", personAge='" + getPersonAge() + "'" +
                "}";
    }

}

package com.awsquickstarts;

public class Person {

    private String personDocumentNumber;

    private String personBirthCountry;

    private String personName;

    private String personGender;

    private Integer personAge;

    private String personBirthDate;

    private String personCreateDate;

    public String getPersonDocumentNumber() {
        return this.personDocumentNumber;
    }

    public void setPersonDocumentNumber(String personDocumentNumber) {
        this.personDocumentNumber = personDocumentNumber;
    }

    public String getPersonBirthCountry() {
        return this.personBirthCountry;
    }

    public void setPersonBirthCountry(String personBirthCountry) {
        this.personBirthCountry = personBirthCountry;
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

    public String getPersonBirthDate() {
        return this.personBirthDate;
    }

    public void setPersonBirthDate(String personBirthDate) {
        this.personBirthDate = personBirthDate;
    }

    public String getPersonCreateDate() {
        return this.personCreateDate;
    }

    public void setPersonCreateDate(String personCreateDate) {
        this.personCreateDate = personCreateDate;
    }

    @Override
    public String toString() {
        return "{" +
                " personDocumentNumber='" + getPersonDocumentNumber() + "'" +
                ", personBirthCountry='" + getPersonBirthCountry() + "'" +
                ", personName='" + getPersonName() + "'" +
                ", personGender='" + getPersonGender() + "'" +
                ", personAge='" + getPersonAge() + "'" +
                ", personBirthDate='" + getPersonBirthDate() + "'" +
                ", personCreateDate='" + getPersonCreateDate() + "'" +
                "}";
    }

}
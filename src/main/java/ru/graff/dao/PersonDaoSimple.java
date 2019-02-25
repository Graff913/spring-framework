package ru.graff.dao;

import ru.graff.domain.Person;

public class PersonDaoSimple implements PersonDao {

    @Override
    public Person createPerson(String name, String surname) {
        return new Person(name, surname);
    }

}

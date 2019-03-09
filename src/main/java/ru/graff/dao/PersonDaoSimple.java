package ru.graff.dao;

import org.springframework.stereotype.Repository;
import ru.graff.domain.Person;

@Repository
public class PersonDaoSimple implements PersonDao {

    @Override
    public Person createPerson(String name, String surname) {
        return new Person(name, surname);
    }

}

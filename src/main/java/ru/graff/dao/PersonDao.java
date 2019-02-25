package ru.graff.dao;

import ru.graff.domain.Person;

public interface PersonDao {

    Person createPerson(String name, String surname);

}

package ru.graff.dao;

import org.junit.jupiter.api.Test;
import ru.graff.domain.Person;

import static org.junit.jupiter.api.Assertions.*;

class PersonDaoSimpleTest {

    @Test
    void createPerson() {
        String name = "Name", surname = "Surname";
        PersonDao personDao = new PersonDaoSimple();
        Person person = personDao.createPerson(name, surname);
        assertEquals("Name", person.getName());
        assertEquals("Surname", person.getSurname());
        assertEquals(0, person.getAnswers().size());
    }

}
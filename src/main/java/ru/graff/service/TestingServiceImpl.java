package ru.graff.service;

import ru.graff.dao.PersonDao;
import ru.graff.dao.TestingDao;
import ru.graff.domain.Person;
import ru.graff.domain.Question;

import java.util.Scanner;

public class TestingServiceImpl implements TestingService {

    private final PersonDao personDao;
    private final TestingDao testingDao;

    public TestingServiceImpl(PersonDao personDao, TestingDao testingDao) {
        this.personDao = personDao;
        this.testingDao = testingDao;
    }

    @Override
    public void startTest() {
        Scanner in = new Scanner(System.in);
        System.out.println("Укажите свое имя:");
        String name = in.nextLine();
        System.out.println("Укажите свою фамилию:");
        String surname = in.nextLine();
        Person person = personDao.createPerson(name, surname);
        startTest(person);
    }

    private void startTest(Person person) {
        testingDao.createQuestion();
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            Question question = testingDao.getQuestion(i);
            System.out.println(question.getQuestion());
            System.out.println(question.getAnswer());
            person.addAnswer(in.nextInt());
        }
        resultTest(person);
    }

    private void resultTest(Person person) {
        System.out.println("\nТест выполнен!");
        System.out.println("Результаты теста: " + person.getName() + " " + person.getSurname());
        for (int i = 0; i < 5; i++) {
            System.out.println(testingDao.getQuestion(i).getQuestion() + " " + (testingDao.checkAnswer(i, person.getAnswers().get(i)) ? "Правильно" : "Не правильно"));
        }
    }

}

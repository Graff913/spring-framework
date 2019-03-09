package ru.graff.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.graff.dao.PersonDao;
import ru.graff.dao.TestingDao;
import ru.graff.domain.Person;

import java.util.Locale;
import java.util.Scanner;

@Service
public class TestingServiceImpl implements TestingService {

    @Autowired
    private MessageSource messageSource;

    private final PersonDao personDao;
    private final TestingDao testingDao;

    public TestingServiceImpl(PersonDao personDao, TestingDao testingDao) {
        this.personDao = personDao;
        this.testingDao = testingDao;
    }

    @Override
    public void startTest() {
        Locale locale = Locale.getDefault();
        Scanner in = new Scanner(System.in);
        System.out.println("Are you from country (EN)? (Из какой вы страны (RU)?)");
        if (in.nextLine().equals("EN")) {
            locale = Locale.ENGLISH;
        }
        if (in.nextLine().equals("RU")) {
            locale = new Locale("ru", "RU");
        }

        System.out.println(messageSource.getMessage("enter.name", new String[] {}, locale));
        String name = in.nextLine();
        System.out.println(messageSource.getMessage("enter.surname", new String[] {}, locale));
        String surname = in.nextLine();
        Person person = personDao.createPerson(name, surname);

        testingDao.readQuestions(locale);
        for (int i = 0; i < 5; i++) {
            System.out.println(testingDao.getQuestion(i));
            person.addAnswer(in.nextInt());
        }

        System.out.println(messageSource.getMessage("test.completed", new String[] {}, locale));
        System.out.println(messageSource.getMessage("test.result", new String[] {}, locale) + " " + person.getName() + " " + person.getSurname());
        for (int i = 0; i < 5; i++) {
            System.out.println(testingDao.getQuestion(i).getQuestion() + " " + (testingDao.checkAnswer(i, person.getAnswers().get(i))
                    ? messageSource.getMessage("question.right", new String[] {}, locale)
                    : messageSource.getMessage("question.wrong", new String[] {}, locale)));
        }
    }

}

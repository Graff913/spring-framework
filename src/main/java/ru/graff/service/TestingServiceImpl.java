package ru.graff.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.graff.dao.PersonDao;
import ru.graff.dao.TestingDao;
import ru.graff.domain.Person;

import java.util.Locale;
import java.util.Scanner;

@PropertySource("classpath:application.properties")
@Service
public class TestingServiceImpl implements TestingService {

    private Locale locale;
    private final MessageSource messageSource;
    private final PersonDao personDao;
    private final TestingDao testingDao;

    public TestingServiceImpl(@Value("${locale}")String locale, MessageSource messageSource, PersonDao personDao, TestingDao testingDao) {
        this.messageSource = messageSource;
        this.personDao = personDao;
        this.testingDao = testingDao;
        this.locale = Locale.getDefault();
        if (locale.equals("EN")) {
            this.locale = Locale.ENGLISH;
        } else if (locale.equals("RU")) {
            this.locale = new Locale("ru", "RU");
        }
    }

    @Override
    public void startTest() {
        Scanner in = new Scanner(System.in);
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

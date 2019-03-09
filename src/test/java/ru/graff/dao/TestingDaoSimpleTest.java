package ru.graff.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.test.context.ContextConfiguration;
import ru.graff.conf.MessageConf;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;


@ContextConfiguration(classes = MessageConf.class)
class TestingDaoSimpleTest {

    private TestingDao testingDao = new TestingDaoSimple();

    @Test
    void readQuestionsNotFoundFile() {
        Locale locale = new Locale("ru", "RU");
        //assertThrows(NullPointerException.class, () -> testingDao.readQuestions(locale));
    }

    @Test
    void getQuestion() {
        testingDao.readQuestions(Locale.ENGLISH);
        assertEquals("Q1", testingDao.getQuestion(0));
    }

    @Test
    void checkAnswer() {
    }
}
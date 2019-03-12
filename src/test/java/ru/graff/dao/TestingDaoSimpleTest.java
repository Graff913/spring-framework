package ru.graff.dao;

import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class TestingDaoSimpleTest {

    @Test
    void readQuestionsNotFoundFile() {
        TestingDao testingDao = new TestingDaoSimple("tests_not_found.csv");
        Locale locale = new Locale("ru", "RU");
        assertThrows(NullPointerException.class, () -> testingDao.readQuestions(locale));
    }

    @Test
    void getQuestion() {
        TestingDao testingDao = new TestingDaoSimple("tests.csv");
        testingDao.readQuestions(Locale.ENGLISH);
        assertEquals("Q1\nA1, A2, A3, A4", testingDao.getQuestion(0).toString());
        assertEquals("Q2\nA1, A2, A3, A4", testingDao.getQuestion(1).toString());
        assertEquals("Q3\nA1, A2, A3, A4", testingDao.getQuestion(2).toString());
        assertEquals("Q4\nA1, A2, A3, A4", testingDao.getQuestion(3).toString());
        assertEquals("Q5\nA1, A2, A3, A4", testingDao.getQuestion(4).toString());
    }

    @Test
    void checkAnswer() {
        TestingDao testingDao = new TestingDaoSimple("tests.csv");
        testingDao.readQuestions(Locale.ENGLISH);
        assertTrue(testingDao.checkAnswer(0, 1));
        assertFalse(testingDao.checkAnswer(1, 4));
        assertTrue(testingDao.checkAnswer(2, 3));
        assertTrue(testingDao.checkAnswer(3, 4));
        assertFalse(testingDao.checkAnswer(4, 5));
    }

}
package ru.graff.dao;

import ru.graff.domain.Question;

import java.util.Locale;

public interface TestingDao {

    void readQuestions(Locale locale);
    Question getQuestion(int number);
    boolean checkAnswer(int number, int answer);

}

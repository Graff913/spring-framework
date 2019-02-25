package ru.graff.dao;

import ru.graff.domain.Question;

public interface TestingDao {

    void createQuestion();
    Question getQuestion(int number);
    boolean checkAnswer(int number, int answer);

}

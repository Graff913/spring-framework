package ru.graff.domain;

public class Question {

    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private int answer;

    public Question(String question, String answer1, String answer2, String answer3, String answer4, int answer) {
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public boolean checkAnswer(int answer) {
        return this.answer == answer;
    }

    @Override
    public String toString() {
        return question + "\n" +
                answer1 + ", " +
                answer2 + ", " +
                answer3 + ", " +
                answer4;
    }

}

package ru.graff.domain;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private String surname;
    private List<Integer> answers = new ArrayList<>();

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void addAnswer(Integer answer) {
        answers.add(answer);
    }

    public List<Integer> getAnswers() {
        return answers;
    }

}

package ru.graff.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Repository;
import ru.graff.domain.Question;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Repository
public class TestingDaoSimple implements TestingDao {

    private static String CSV_SPLIT = ";";

    @Autowired
    private MessageSource messageSource;

    private List<Question> questions = new ArrayList<>();

    @Override
    public void readQuestions(Locale locale) {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource(messageSource.getMessage("file.path", new String[] {}, locale)).getFile());
            List<String> lines = Files.readAllLines(file.toPath());
            for (String line : lines) {
                String[] temps = line.split(CSV_SPLIT);
                Question question = new Question(temps[0], temps[1], temps[2], temps[3], temps[4], Integer.parseInt(temps[5]));
                questions.add(question);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Question getQuestion(int number) {
        return questions.get(number);
    }

    @Override
    public boolean checkAnswer(int number, int answer) {
        return getQuestion(number).checkAnswer(answer);
    }

}

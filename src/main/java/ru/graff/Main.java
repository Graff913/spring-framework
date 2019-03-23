package ru.graff;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.graff.service.TestingService;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        TestingService testingService = context.getBean(TestingService.class);
        testingService.startTest();
    }

}

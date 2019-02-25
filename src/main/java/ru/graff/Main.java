package ru.graff;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.graff.service.TestingService;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        TestingService testingService = context.getBean(TestingService.class);
        testingService.startTest();
    }

}

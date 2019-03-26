package ru.graff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
//        ApplicationContext context = SpringApplication.run(Main.class, args);
//        TestingService testingService = context.getBean(TestingService.class);
//        testingService.startTest();
    }

}

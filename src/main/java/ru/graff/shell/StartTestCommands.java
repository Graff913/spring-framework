package ru.graff.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.graff.service.TestingService;

@ShellComponent
public class StartTestCommands {

    private final TestingService service;

    public StartTestCommands(TestingService service) {
        this.service = service;
    }

    @ShellMethod("Translate text from one language to another.")
    public void startTest() {
        service.startTest();
    }

}

package name.hanyi.calendar;

import name.hanyi.calendar.api.CalendarCommand;
import name.hanyi.calendar.factory.CalendarCommandFactory;

import java.io.Console;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class CalendarConsole {
    public void run() {
        Console console = System.console();
        console.format("Welcome, press h for help\n");
        if (isNull(console)) {
            console.format("No console.\n");
            System.exit(-1);
        }
        while (true) {
            String commandString = console.readLine("$ ");
            CalendarCommand command = CalendarCommandFactory.getInstance(commandString);
            if (nonNull(command)) {
                command.execute(console);
            } else {
                console.format("Unknown commands.\n");
            }
        }
    }
}

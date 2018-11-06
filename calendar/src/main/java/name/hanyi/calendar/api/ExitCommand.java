package name.hanyi.calendar.api;

import java.io.Console;

public class ExitCommand implements CalendarCommand {
    @Override
    public String getName() {
        return "q";
    }

    @Override
    public void execute(Console console) {
        console.format("Bye.\n");
        System.exit(0);
    }

    @Override
    public String getHelp() {
        return "quit";
    }
}

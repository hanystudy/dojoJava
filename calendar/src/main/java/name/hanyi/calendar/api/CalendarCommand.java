package name.hanyi.calendar.api;

import java.io.Console;

public interface CalendarCommand {
    String getName();
    void execute(Console console);
    String getHelp();
}

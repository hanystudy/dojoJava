package name.hanyi.calendar.api;

import java.io.Console;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentTimeCommand implements CalendarCommand {

    @Override
    public String getName() {
        return "now";
    }

    @Override
    public void execute(Console console) {
        LocalDateTime now = LocalDateTime.now();
        console.format("%s\n", now.format(DateTimeFormatter.ofPattern("hh:mm a")));
    }

    @Override
    public String getHelp() {
        return "print current time";
    }
}

package name.hanyi.calendar.api;

import java.io.Console;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class CurrentCalendarCommand implements CalendarCommand {

    private static final String FORMAT_STRING = "%-5s";
    private DayOfWeek[] dayOfWeeks = new DayOfWeek[] {
            DayOfWeek.MONDAY,
            DayOfWeek.TUESDAY,
            DayOfWeek.WEDNESDAY,
            DayOfWeek.THURSDAY,
            DayOfWeek.FRIDAY,
            DayOfWeek.SATURDAY,
            DayOfWeek.SUNDAY
    };

    @Override
    public String getName() {
        return "today";
    }

    @Override
    public void execute(Console console) {
        LocalDate today = LocalDate.now();
        console.format("%s\n", today.format(DateTimeFormatter.ofPattern("MMM d yyyy")));
        printDaysOfWeek(console);
        printCalendar(console, today);
        console.format("\n");
    }

    @Override
    public String getHelp() {
        return "print current calendar";
    }

    private void printCalendar(Console console, LocalDate today) {
        int year = today.getYear();
        Month month = today.getMonth();
        int lengthOfMonth = month.length(Year.isLeap(year));
        DayOfWeek weekOfFirstDayMonth = LocalDate.of(year, month, 1).getDayOfWeek();
        int dayOfMonth = today.getDayOfMonth();
        int skipDay = weekOfFirstDayMonth.getValue();
        for (int i = 1, j = 1; i <= lengthOfMonth; j++) {
            if (j < skipDay) {
                console.format(FORMAT_STRING, "");
            } else {
                if (dayOfMonth == i) {
                    console.format(FORMAT_STRING,"*" + i);
                } else {
                    console.format(FORMAT_STRING, i);
                }
                if (j % dayOfWeeks.length == 0) {
                    console.format("\n");
                }
                ++i;
            }
        }
    }

    private void printDaysOfWeek(Console console) {
        for (DayOfWeek day : dayOfWeeks) {
            console.format(FORMAT_STRING, day.getDisplayName(TextStyle.SHORT, Locale.getDefault()));
        }
        console.format("\n");
    }
}

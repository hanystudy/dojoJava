package name.hanyi.calendar.factory;

import name.hanyi.calendar.api.CalendarCommand;
import name.hanyi.calendar.api.CurrentCalendarCommand;
import name.hanyi.calendar.api.CurrentTimeCommand;
import name.hanyi.calendar.api.ExitCommand;
import name.hanyi.calendar.api.InternationalTimeCommand;

import java.io.Console;
import java.util.HashMap;
import java.util.Map;

public class CalendarCommandFactory {

    private static Map<String, CalendarCommand> commandMap = new HashMap<>();
    private static CalendarCommand helpCommand = new HelpCommand();
    private static CalendarCommand[] commands = new CalendarCommand[] {
        new CurrentTimeCommand(),
        new CurrentCalendarCommand(),
        new InternationalTimeCommand(),
        new ExitCommand()
    };

    static {
        for (CalendarCommand command : commands) {
            commandMap.put(command.getName(), command);
        }
        commandMap.put(helpCommand.getName(), helpCommand);
    }

    public static CalendarCommand getInstance(String commandString) {
        return commandMap.get(commandString);
    }

    private static class HelpCommand implements CalendarCommand {

        @Override
        public String getName() {
            return "h";
        }

        @Override
        public void execute(Console console) {
            for (CalendarCommand command : commands) {
                console.format("%s %s\n", "[" + command.getName() + "]", command.getHelp());
            }
        }

        @Override
        public String getHelp() {
            return "print help";
        }
    }
}

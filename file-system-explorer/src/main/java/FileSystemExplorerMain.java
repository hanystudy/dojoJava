import name.hanyi.filesystemexplorer.FileSystemExplorer;

import java.io.Console;
import java.io.IOException;

import static java.util.Objects.isNull;

public class FileSystemExplorerMain {

    public static final String PREFIX_STRING = "$ ";
    public static final String NO_CONSOLE = "No console.";

    public static void main(String[] args) throws IOException {
        Console console = System.console();
        if (isNull(console)) {
            System.err.println(NO_CONSOLE);
            System.exit(1);
        }
        FileSystemExplorer.printWelcome(console);
        while (true) {
            String commandString = console.readLine(PREFIX_STRING);
            FileSystemExplorer.run(commandString, console);
        }
    }
}

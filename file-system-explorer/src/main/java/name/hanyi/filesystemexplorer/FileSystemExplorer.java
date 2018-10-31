package name.hanyi.filesystemexplorer;

import name.hanyi.filesystemexplorer.api.FileSystemCommand;
import name.hanyi.filesystemexplorer.factory.FileSystemCommandFactory;
import name.hanyi.filesystemexplorer.model.FileSystemModel;

import java.io.Console;
import java.io.IOException;

import static java.util.Objects.nonNull;

public class FileSystemExplorer {

    public static final String UNKNOWN_COMMANDS = "Unknown commands";
    private static final FileSystemModel fileSystemModel = new FileSystemModel();;

    private FileSystemExplorer() {
    }

    public static void printWelcome(Console console) {
        console.format("Welcome, press h for help\n");
    }

    public static void run(String name, Console console) throws IOException {
        FileSystemCommand command = FileSystemCommandFactory.getInstance(name);
        if (nonNull(command)) {
            command.execute(console, fileSystemModel);
        } else {
            console.format("%s\n", UNKNOWN_COMMANDS);
        }
    }
}

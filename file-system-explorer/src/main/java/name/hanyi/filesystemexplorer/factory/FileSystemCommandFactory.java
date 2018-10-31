package name.hanyi.filesystemexplorer.factory;

import name.hanyi.filesystemexplorer.api.CreateDirectoryCommand;
import name.hanyi.filesystemexplorer.api.ExitCommand;
import name.hanyi.filesystemexplorer.api.FileStoreCommand;
import name.hanyi.filesystemexplorer.api.FileSystemCommand;
import name.hanyi.filesystemexplorer.api.PresentDirectoryCommand;
import name.hanyi.filesystemexplorer.api.RootDirectoriesCommand;

import java.io.Console;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileSystemCommandFactory {

    private static Map<String, FileSystemCommand> commandMap = new HashMap();
    private static FileSystemCommand[] commandList = new FileSystemCommand[]{
            new CreateDirectoryCommand(),
            new PresentDirectoryCommand(),
            new FileStoreCommand(),
            new RootDirectoriesCommand(),
            new HelpCommand(),
            new ExitCommand()
    };

    static {
        for (FileSystemCommand command : commandList) {
            commandMap.put(command.getName(), command);
        }
    }

    private FileSystemCommandFactory() {
    }

    public static FileSystemCommand getInstance(String name) {
        return commandMap.get(name.toLowerCase());
    }

    public static FileSystemCommand[] getInstances() {
        return commandList;
    }

    private static class HelpCommand implements FileSystemCommand {

        @Override
        public String getName() {
            return "h";
        }

        @Override
        public String getHelp() {
            return "help";
        }

        @Override
        public void execute(Console console) throws IOException {
            for (FileSystemCommand command : commandList) {
                console.format("[%s] %s\n", command.getName(), command.getHelp());
            }
        }
    }
}

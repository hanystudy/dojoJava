package name.hanyi.filesystemexplorer.api;

import java.io.Console;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RemoveCommand extends SimpleFileSystemCommand {

    @Override
    public String getName() {
        return "rm";
    }

    @Override
    public String getHelp() {
        return "remove files or directories";
    }

    @Override
    public void execute(Console console) throws IOException {
        String pathString = console.readLine("input path:");
        try {
            Files.deleteIfExists(Paths.get(pathString));
            console.format("%s\n", "Deleted");
        } catch (DirectoryNotEmptyException ex) {
            console.format("Directory not empty\n");
        }
    }
}

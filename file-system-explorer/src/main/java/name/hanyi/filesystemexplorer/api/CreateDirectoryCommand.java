package name.hanyi.filesystemexplorer.api;

import java.io.Console;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CreateDirectoryCommand implements FileSystemCommand {

    @Override
    public String getName() {
        return "mkdir";
    }

    @Override
    public String getHelp() {
        return "create directories";
    }

    @Override
    public void execute(Console console) throws IOException {
        String pathString = console.readLine("input path:");
        try {
            Files.createDirectories(Paths.get(pathString));
            console.format("%s\n", "Directory created.");
        } catch (FileAlreadyExistsException ex) {
            console.format("Path already exist\n");
        }
    }
}

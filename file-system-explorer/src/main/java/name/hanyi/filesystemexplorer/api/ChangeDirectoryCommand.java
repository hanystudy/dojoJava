package name.hanyi.filesystemexplorer.api;

import name.hanyi.filesystemexplorer.model.FileSystemModel;

import java.io.Console;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ChangeDirectoryCommand extends SimpleFileSystemCommand {

    @Override
    public String getName() {
        return "cd";
    }

    @Override
    public String getHelp() {
        return "change present directory";
    }

    @Override
    public void execute(Console console, FileSystemModel fileSystemModel) throws IOException {
        String pathString = console.readLine("input path:");
        Path path = Paths.get(pathString);
        if (!path.isAbsolute()) {
            path = fileSystemModel.getCurrentDirectory().resolve(path);
        }
        if (Files.isDirectory(path)) {
            fileSystemModel.setCurrentDirectory(path);
            console.format("Working directory is changed\n");
        } else {
            console.format("Target path is invalid\n");
        }
    }
}

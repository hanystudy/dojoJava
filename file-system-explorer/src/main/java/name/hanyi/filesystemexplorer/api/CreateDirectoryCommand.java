package name.hanyi.filesystemexplorer.api;

import name.hanyi.filesystemexplorer.model.FileSystemModel;
import name.hanyi.filesystemexplorer.util.PathUtil;

import java.io.Console;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateDirectoryCommand extends SimpleFileSystemCommand {

    @Override
    public String getName() {
        return "mkdir";
    }

    @Override
    public String getHelp() {
        return "create directories";
    }

    @Override
    public void execute(Console console, FileSystemModel fileSystemModel) throws IOException {
        String pathString = console.readLine("input path:");
        try {
            final Path path = PathUtil.getAbsolutePath(fileSystemModel, Paths.get(pathString));
            Files.createDirectories(path);
            console.format("%s\n", "Directory created.");
        } catch (FileAlreadyExistsException ex) {
            console.format("Path already exist\n");
        }
    }
}

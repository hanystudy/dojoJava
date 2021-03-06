package name.hanyi.filesystemexplorer.api;

import name.hanyi.filesystemexplorer.model.FileSystemModel;
import name.hanyi.filesystemexplorer.util.PathUtil;

import java.io.Console;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.Path;
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
    public void execute(Console console, FileSystemModel fileSystemModel) throws IOException {
        String pathString = console.readLine("input path:");
        try {
            final Path path = PathUtil.getAbsolutePath(fileSystemModel, Paths.get(pathString));
            Files.deleteIfExists(path);
            console.format("%s\n", "Deleted");
        } catch (DirectoryNotEmptyException ex) {
            console.format("Directory not empty\n");
        }
    }
}

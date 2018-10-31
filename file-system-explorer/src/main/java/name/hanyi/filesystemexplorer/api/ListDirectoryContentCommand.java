package name.hanyi.filesystemexplorer.api;

import name.hanyi.filesystemexplorer.model.FileSystemModel;
import name.hanyi.filesystemexplorer.util.PathUtil;

import java.io.Console;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ListDirectoryContentCommand extends SimpleFileSystemCommand {

    @Override
    public String getName() {
        return "ls";
    }

    @Override
    public String getHelp() {
        return "list directories";
    }

    @Override
    public void execute(Console console, FileSystemModel fileSystemModel) throws IOException {
        String pathString = console.readLine("input path:");
        final Path path = PathUtil.getAbsolutePath(fileSystemModel, Paths.get(pathString));
        if (Files.notExists(path)) {
            console.format("Path not exist\n");
            return;
        }
        DirectoryStream<Path> stream = Files.newDirectoryStream(path);
        for (Path p : stream) {
            console.format("%s\n", p.getFileName());
        }
    }
}

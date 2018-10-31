package name.hanyi.filesystemexplorer.api;

import java.io.Console;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ListDirectoryContentCommand implements FileSystemCommand {

    @Override
    public String getName() {
        return "ls";
    }

    @Override
    public String getHelp() {
        return "list directories";
    }

    @Override
    public void execute(Console console) throws IOException {
        String pathString = console.readLine("input path:");
        final Path path = Paths.get(pathString);
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

package name.hanyi.filesystemexplorer.api;

import java.io.Console;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateFileCommand extends SimpleFileSystemCommand {

    @Override
    public String getName() {
        return "create";
    }

    @Override
    public String getHelp() {
        return "create file";
    }

    @Override
    public void execute(Console console) throws IOException {
        Path path = getPath(console);
        try {
            Files.createFile(path);
        } catch (IOException ex) {
            console.format("Can not create file\n");
        }
    }

    private Path getPath(Console console) {
        String pathString = console.readLine("input path:");
        return Paths.get(pathString);
    }
}

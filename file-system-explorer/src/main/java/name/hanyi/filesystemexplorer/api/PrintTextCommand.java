package name.hanyi.filesystemexplorer.api;

import name.hanyi.filesystemexplorer.model.FileSystemModel;
import name.hanyi.filesystemexplorer.util.PathUtil;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.util.Objects.nonNull;

public class PrintTextCommand extends SimpleFileSystemCommand {

    @Override
    public String getName() {
        return "cat";
    }

    @Override
    public String getHelp() {
        return "print file in text";
    }

    @Override
    public void execute(Console console, FileSystemModel fileSystemModel) throws IOException {
        Path path = PathUtil.getAbsolutePath(fileSystemModel, getPath(console));
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            StringBuilder builder = new StringBuilder();
            String line = null;
            while (nonNull(line = reader.readLine())) {
                builder.append(line + "\n");
            }
            console.format("%s", builder.toString());
        } catch (IOException ex) {
            console.format("Can not read file\n");
        }
    }

    private Path getPath(Console console) {
        String pathString = console.readLine("input path:");
        return Paths.get(pathString);
    }
}

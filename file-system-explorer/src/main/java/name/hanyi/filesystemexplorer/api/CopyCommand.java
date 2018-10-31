package name.hanyi.filesystemexplorer.api;

import name.hanyi.filesystemexplorer.model.FileSystemModel;
import name.hanyi.filesystemexplorer.util.PathUtil;

import java.io.Console;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CopyCommand extends SimpleFileSystemCommand {

    @Override
    public String getName() {
        return "cp";
    }

    @Override
    public String getHelp() {
        return "copy files or directories";
    }

    @Override
    public void execute(Console console, FileSystemModel fileSystemModel) throws IOException {
        String sourcePathString = console.readLine("input source path:");
        Path sourcePath = PathUtil.getAbsolutePath(fileSystemModel, Paths.get(sourcePathString));
        if (Files.exists(sourcePath)) {
            String targetPathString = console.readLine("input target path:");
            Path targetPath = PathUtil.getAbsolutePath(fileSystemModel, Paths.get(targetPathString));
            if (Files.exists(targetPath)) {
                String replace = console.readLine("Target path exists, overwrite? (y)");
                try {
                    if (replace.equalsIgnoreCase("y")) {
                        Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
                        printResult(console);
                        return;
                    }

                } catch (DirectoryNotEmptyException ex) {
                    console.format("Target directory not empty\n");
                    return;
                }
            }
            Files.copy(sourcePath, targetPath);
            printResult(console);
        }
    }

    private void printResult(Console console) {
        console.format("%s\n", "Copied");
    }
}

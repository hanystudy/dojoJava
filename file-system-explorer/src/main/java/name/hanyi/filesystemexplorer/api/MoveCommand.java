package name.hanyi.filesystemexplorer.api;

import java.io.Console;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class MoveCommand extends SimpleFileSystemCommand {

    @Override
    public String getName() {
        return "mv";
    }

    @Override
    public String getHelp() {
        return "move files or directories";
    }

    @Override
    public void execute(Console console) throws IOException {
        String sourcePathString = console.readLine("input source path:");
        Path sourcePath = Paths.get(sourcePathString);
        if (Files.exists(sourcePath)) {
            String targetPathString = console.readLine("input target path:");
            Path targetPath = Paths.get(targetPathString);
            if (Files.exists(targetPath)) {
                String replace = console.readLine("Target path exists, overwrite? (y)");
                try {
                    if (replace.equalsIgnoreCase("y")) {
                        Files.move(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
                        printResult(console);
                        return;
                    }

                } catch (DirectoryNotEmptyException ex) {
                    console.format("Target directory not empty\n");
                    return;
                }
            }
            Files.move(sourcePath, targetPath);
            printResult(console);
        }
    }

    private void printResult(Console console) {
        console.format("%s\n", "Moved");
    }
}

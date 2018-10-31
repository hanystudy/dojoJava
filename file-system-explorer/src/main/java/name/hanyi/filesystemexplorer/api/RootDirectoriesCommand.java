package name.hanyi.filesystemexplorer.api;

import java.io.Console;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class RootDirectoriesCommand implements FileSystemCommand {

    @Override
    public String getName() {
        return "r";
    }

    @Override
    public String getHelp() {
        return "list root directories";
    }

    @Override
    public void execute(Console console) throws IOException {
        for (Path path : FileSystems.getDefault().getRootDirectories()) {
            console.format("%s\n", path.toString());
        }
    }
}

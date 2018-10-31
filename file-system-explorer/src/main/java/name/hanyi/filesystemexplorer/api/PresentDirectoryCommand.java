package name.hanyi.filesystemexplorer.api;

import java.io.Console;
import java.io.IOException;

public class PresentDirectoryCommand implements FileSystemCommand {

    @Override
    public String getName() {
        return "pwd";
    }

    @Override
    public String getHelp() {
        return "present working directory";
    }

    @Override
    public void execute(Console console) throws IOException {
        console.format("%s\n", System.getProperty("user.dir"));
    }
}

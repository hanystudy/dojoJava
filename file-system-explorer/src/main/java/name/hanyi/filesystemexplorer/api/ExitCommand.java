package name.hanyi.filesystemexplorer.api;

import java.io.Console;
import java.io.IOException;

public class ExitCommand extends SimpleFileSystemCommand {

    @Override
    public String getName() {
        return "q";
    }

    @Override
    public String getHelp() {
        return "quit";
    }

    @Override
    public void execute(Console console) throws IOException {
        console.format("Bye\n");
        System.exit(0);
    }
}

package name.hanyi.filesystemexplorer.api;

import java.io.Console;
import java.io.IOException;

public interface FileSystemCommand {

    String getName();

    String getHelp();

    void execute(Console console) throws IOException;
}

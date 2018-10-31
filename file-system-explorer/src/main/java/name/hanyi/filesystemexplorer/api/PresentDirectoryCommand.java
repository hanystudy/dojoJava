package name.hanyi.filesystemexplorer.api;

import name.hanyi.filesystemexplorer.model.FileSystemModel;

import java.io.Console;
import java.io.IOException;

public class PresentDirectoryCommand extends SimpleFileSystemCommand {

    @Override
    public String getName() {
        return "pwd";
    }

    @Override
    public String getHelp() {
        return "present working directory";
    }

    @Override
    public void execute(Console console, FileSystemModel fileSystemModel) throws IOException {
        console.format("%s\n", fileSystemModel.getCurrentDirectory().toString());
    }
}

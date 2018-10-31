package name.hanyi.filesystemexplorer.api;

import name.hanyi.filesystemexplorer.model.FileSystemModel;

import java.io.Console;
import java.io.IOException;

public abstract class SimpleFileSystemCommand implements FileSystemCommand {
    public void execute(Console console) throws IOException {
    }

    public void execute(Console console, FileSystemModel model) throws IOException {
        execute(console);
    }
}

package name.hanyi.filesystemexplorer.api;

import name.hanyi.filesystemexplorer.model.FileSystemModel;

import java.io.Console;
import java.io.IOException;

public interface FileSystemCommand {

    String getName();

    String getHelp();

    void execute(Console console) throws IOException;

    void execute(Console console, FileSystemModel model) throws IOException;
}

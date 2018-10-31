package name.hanyi.filesystemexplorer.model;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSystemModel {
    private Path currentDirectory;

    public FileSystemModel() {
        currentDirectory = Paths.get(System.getProperty("user.dir"));
    }

    public Path getCurrentDirectory() {
        return currentDirectory;
    }

    public void setCurrentDirectory(Path currentDirectory) {
        this.currentDirectory = currentDirectory;
    }
}

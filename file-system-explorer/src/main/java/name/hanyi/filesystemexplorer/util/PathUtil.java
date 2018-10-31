package name.hanyi.filesystemexplorer.util;

import name.hanyi.filesystemexplorer.model.FileSystemModel;

import java.nio.file.Path;

public class PathUtil {
    private PathUtil() {
    }

    public static Path getAbsolutePath(FileSystemModel fileSystemModel, Path path) {
        if (path.isAbsolute()) {
            return path;
        } else {
            return fileSystemModel.getCurrentDirectory().resolve(path);
        }
    }
}

package name.hanyi.filesystemexplorer.api;

import java.io.Console;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

public class FindDirectoryContentCommand implements FileSystemCommand {

    @Override
    public String getName() {
        return "find";
    }

    @Override
    public String getHelp() {
        return "find content in directory";
    }

    @Override
    public void execute(Console console) throws IOException {
        String pathString = console.readLine("input path:");
        String patternString = console.readLine("input pattern:");
        Finder finder = new Finder(patternString);
        Files.walkFileTree(Paths.get(pathString), finder);
        for (Path path : finder.getResult()) {
            console.format("%s\n", path);
        }
    }

    private static class Finder extends SimpleFileVisitor<Path> {

        private final PathMatcher matcher;
        private List<Path> result = new ArrayList<>();

        public Finder(String pattern) {
            this.matcher = FileSystems.getDefault().getPathMatcher("glob:" + pattern);
        }

        public List<Path> getResult() {
            return result;
        }

        private void find(Path file) {
            Path name = file.getFileName();
            if (nonNull(name) && matcher.matches(name)) {
                result.add(file);
            }
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) {
            find(file);
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attributes) {
            find(dir);
            return FileVisitResult.CONTINUE;
        }
    }
}

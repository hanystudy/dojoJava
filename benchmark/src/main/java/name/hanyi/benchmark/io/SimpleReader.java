package name.hanyi.benchmark.io;

import name.hanyi.benchmark.datastructure.BaseDataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SimpleReader implements Reader<String> {

    private Path path;

    public SimpleReader(Path path) {
        this.path = path;
    }

    @Override
    public void read(BaseDataStructure<String> dataStructure) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                dataStructure.add(line);
            }
        }
    }
}

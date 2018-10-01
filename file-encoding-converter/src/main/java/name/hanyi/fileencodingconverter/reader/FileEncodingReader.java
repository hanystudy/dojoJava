package name.hanyi.fileencodingconverter.reader;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface FileEncodingReader {
    List<Integer> readPath(Path path) throws IOException;
}

package name.hanyi.fileencodingconverter.writer;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface FileEncodingWriter {
    void writePath(List<Integer> list, Path path) throws IOException;
}

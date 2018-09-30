package name.hanyi.karatechop.reader;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface KarateChopReader {
    List<Integer> readPath(Path path) throws IOException;
}

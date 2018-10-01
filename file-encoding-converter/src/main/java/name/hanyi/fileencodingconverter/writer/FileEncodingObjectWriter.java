package name.hanyi.fileencodingconverter.writer;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.util.List;

public class FileEncodingObjectWriter implements FileEncodingWriter {
    @Override
    public void writePath(List<Integer> list, Path path) throws IOException {
        try (FileOutputStream out = new FileOutputStream(path.toFile());
             BufferedOutputStream bufferedout = new BufferedOutputStream(out);
             ObjectOutputStream outputStream = new ObjectOutputStream(bufferedout)) {
            for (Integer number : list) {
                outputStream.writeObject(number);
            }
        }
    }
}

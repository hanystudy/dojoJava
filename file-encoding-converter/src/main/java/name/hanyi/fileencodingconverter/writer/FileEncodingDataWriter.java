package name.hanyi.fileencodingconverter.writer;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class FileEncodingDataWriter implements FileEncodingWriter {
    @Override
    public void writePath(List<Integer> list, Path path) throws IOException {
        try (FileOutputStream out = new FileOutputStream(path.toFile());
             BufferedOutputStream bufferedout = new BufferedOutputStream(out);
             DataOutputStream outputStream = new DataOutputStream(bufferedout)) {
            for (int number : list) {
                outputStream.writeInt(number);
            }
        }
    }
}

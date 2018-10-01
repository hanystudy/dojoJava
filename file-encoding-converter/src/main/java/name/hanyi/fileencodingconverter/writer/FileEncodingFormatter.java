package name.hanyi.fileencodingconverter.writer;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.List;

public class FileEncodingFormatter implements FileEncodingWriter {
    @Override
    public void writePath(List<Integer> list, Path path) throws IOException {
        try (FileWriter out = new FileWriter(path.toFile());
             BufferedWriter bufferedWriter = new BufferedWriter(out);
             PrintWriter writer = new PrintWriter(bufferedWriter)) {
            for (int number : list) {
                writer.println(number);
            }
        } catch (EOFException e) {
        }
    }
}

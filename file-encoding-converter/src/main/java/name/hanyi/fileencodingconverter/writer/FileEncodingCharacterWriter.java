package name.hanyi.fileencodingconverter.writer;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class FileEncodingCharacterWriter implements FileEncodingWriter {
    @Override
    public void writePath(List<Integer> list, Path path) throws IOException {
        try (FileWriter out = new FileWriter(path.toFile());
             BufferedWriter bufferedWriter = new BufferedWriter(out)) {
            for (int number : list) {
                bufferedWriter.write(String.valueOf(number));
                bufferedWriter.newLine();
            }
        } catch (EOFException e) {
        }
    }
}

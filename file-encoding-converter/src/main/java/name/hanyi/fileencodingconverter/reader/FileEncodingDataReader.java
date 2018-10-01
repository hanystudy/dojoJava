package name.hanyi.fileencodingconverter.reader;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileEncodingDataReader implements FileEncodingReader {
    @Override
    public List<Integer> readPath(Path path) throws IOException {
        List<Integer> inputList = new ArrayList<>();
        try (FileInputStream in = new FileInputStream(path.toFile());
             BufferedInputStream buffedin = new BufferedInputStream(in);
             DataInputStream inputStream = new DataInputStream(buffedin)) {
            int input;
            while (true) {
                input = inputStream.readInt();
                inputList.add(input);
            }
        } catch (EOFException e) {
        }
        return inputList;
    }
}

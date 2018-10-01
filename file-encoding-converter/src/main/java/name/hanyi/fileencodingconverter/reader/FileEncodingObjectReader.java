package name.hanyi.fileencodingconverter.reader;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileEncodingObjectReader implements FileEncodingReader {
    @Override
    public List<Integer> readPath(Path path) throws IOException, ClassNotFoundException {
        List<Integer> inputList = new ArrayList<>();
        try (FileInputStream in = new FileInputStream(path.toFile());
             BufferedInputStream buffedin = new BufferedInputStream(in);
             ObjectInputStream inputStream = new ObjectInputStream(buffedin)) {
            Integer input;
            while (true) {
                input = (Integer) inputStream.readObject();
                inputList.add(input);
            }
        } catch (EOFException e) {
        }
        return inputList;
    }
}

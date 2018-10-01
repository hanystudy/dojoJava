package name.hanyi.fileencodingconverter.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileEncodingCharacterReader implements FileEncodingReader {
    @Override
    public List<Integer> readPath(Path path) throws IOException {
        List<Integer> inputList = new ArrayList<>();
        try (FileReader in = new FileReader(path.toFile());
             BufferedReader bufferedin = new BufferedReader(in)) {
            String numberString;
            while ( (numberString = bufferedin.readLine()) != null) {
                Integer number = Integer.valueOf(numberString);
                inputList.add(number);
            }
        }
        return inputList;
    }
}

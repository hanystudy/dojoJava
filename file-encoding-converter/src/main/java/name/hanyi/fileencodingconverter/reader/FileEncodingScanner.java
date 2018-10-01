package name.hanyi.fileencodingconverter.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileEncodingScanner implements FileEncodingReader {
    @Override
    public List<Integer> readPath(Path path) throws IOException {
        List<Integer> inputList = new ArrayList<>();
        try (FileReader in = new FileReader(path.toFile());
             BufferedReader bufferedin = new BufferedReader(in);
             Scanner scanner = new Scanner(bufferedin)) {
            String numberString;
            scanner.useDelimiter(System.lineSeparator());
            while (scanner.hasNext()) {
                numberString = scanner.next();
                Integer number = Integer.valueOf(numberString);
                inputList.add(number);
            }
        }
        return inputList;
    }
}

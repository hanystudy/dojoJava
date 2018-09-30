package name.hanyi.karatechop.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class KarateChopCharacterReader implements KarateChopReader {

    @Override
    public List<Integer> readPath(Path path) throws IOException {
        List<Integer> inputList = new ArrayList<>();
        try (Reader fileReader = new FileReader(path.toFile());
            BufferedReader reader = new BufferedReader(fileReader)) {
            String numberString;
            while ( (numberString = reader.readLine()) != null) {
                Integer number = Integer.valueOf(numberString);
                inputList.add(number);
            }
        }
        return inputList;
    }
}

package name.hanyi.karatechop;

import name.hanyi.karatechop.reader.KarateChopCharacterReader;
import name.hanyi.karatechop.reader.KarateChopReader;

import java.io.IOException;
import java.nio.file.Path;

public class KarateChop {

    private int input;
    private int[] inputArray;
    private KarateChopReader reader;

    public KarateChop() {
        reader = new KarateChopCharacterReader();
    }

    public int chop(int input, int[] inputArray) {
        this.inputArray = inputArray;
        this.input = input;
        if (inputArray.length == 0) return -1;
        return binary(0, inputArray.length);
    }

    public int binary(int from, int to) {
        int midPos = from + (to - from) / 2;
        if (input == inputArray[midPos]) {
            return midPos;
        } else if (input < inputArray[midPos] && from <= midPos - 1) {
            return binary(from, midPos);
        } else if (input > inputArray[midPos] && midPos <= to - 1) {
            return binary(midPos + 1, to);
        } else {
            return -1;
        }
    }

    public int chopFile(int input, Path path) throws IOException {
        int[] array = reader.readPath(path).stream().mapToInt(Integer::intValue).toArray();
        return chop(input, array);
    }

    public void setReader(KarateChopReader reader) {
        this.reader = reader;
    }
}
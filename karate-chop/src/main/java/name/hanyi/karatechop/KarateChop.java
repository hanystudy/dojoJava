package name.hanyi.karatechop;

public class KarateChop {

    private int input;
    private int[] inputArray;

    public KarateChop() {
    }

    public int chop(int input, int[] inputArray) {
        this.inputArray = inputArray;
        this.input = input;
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
}
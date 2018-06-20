package name.hanyi.marsrover.domain;

public enum Direction {
    EAST("E", 0),
    SOUTH("S", 1),
    WEST("W", 2),
    NORTH("N", 3);

    private String directionText;
    private int sequenceNum;

    Direction(String directionText, int sequenceNum) {
        this.directionText = directionText;
        this.sequenceNum = sequenceNum;
    }

    public String getDirectionText() {
        return this.directionText;
    }

    public static Direction fromString(String text) {
        for(Direction direction : Direction.values()) {
            if(direction.directionText.equalsIgnoreCase(text)) {
                return direction;
            }
        }
        return null;
    }

    public static Direction fromInteger(int sequenceNum) {
        for(Direction direction : Direction.values()) {
            if(direction.sequenceNum == sequenceNum) {
                return direction;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.getDirectionText();
    }

    public Direction getRight() {
        return Direction.fromInteger((this.sequenceNum + 1) % 4);
    }

    public Direction getLeft() {
        int nextSequenceNum = this.sequenceNum == 0 ? 3 : (this.sequenceNum - 1) % 4;
        return Direction.fromInteger(nextSequenceNum);
    }
}

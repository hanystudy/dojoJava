package name.hanyi.marsrover.domain;

public enum Direction {
    EAST("E"),
    SOURTH("S"),
    WEST("W"),
    NORTH("N");

    private String directionText;

    Direction(String directionText) {
        this.directionText = directionText;
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
}

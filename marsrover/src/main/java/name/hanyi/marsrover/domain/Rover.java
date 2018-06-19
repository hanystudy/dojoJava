package name.hanyi.marsrover.domain;

public class Rover {
    private Position position;
    private Direction direction;

    public Rover(int x, int y, String d) {
        this.position = new Position(x, y);
        this.direction = Direction.fromString(d);
    }

    public Position getPosition() {
        return this.position;
    }

    public Direction getDirection() {
        return this.direction;
    }
}

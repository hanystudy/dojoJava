package name.hanyi.marsrover.domain;

import name.hanyi.marsrover.action.Movable;
import name.hanyi.marsrover.action.Turnable;

public class Rover implements Turnable, Movable {
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

    @Override
    public boolean stepForward() {
        return false;
    }

    @Override
    public Direction turnLeft() {
        this.direction = this.direction.getLeft();
        return this.direction;
    }

    @Override
    public Direction turnRight() {
        this.direction = this.direction.getRight();
        return this.direction;
    }
}

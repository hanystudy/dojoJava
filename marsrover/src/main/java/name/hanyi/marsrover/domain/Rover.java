package name.hanyi.marsrover.domain;

import name.hanyi.marsrover.action.Movable;
import name.hanyi.marsrover.action.Turnable;

public class Rover implements Turnable, Movable {
    private Position position;
    private Direction direction;
    private Mars mars;

    public Rover(Mars mars, int x, int y, String d) {
        this.mars = mars;
        this.position = new Position(x, y);
        this.direction = Direction.fromString(d);
    }

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
    public Position stepForward() {
        Position position = forward(this.direction, this.position, 1);
        if(mars == null || mars.validPosition(position)) {
            this.position = position;
        }
        return this.position;
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

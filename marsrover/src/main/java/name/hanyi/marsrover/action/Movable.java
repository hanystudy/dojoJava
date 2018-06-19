package name.hanyi.marsrover.action;

import name.hanyi.marsrover.domain.Direction;
import name.hanyi.marsrover.domain.Position;

public interface Movable {
    public Position stepForward();

    public default Position forward(Direction direction, Position position, int step) {
        switch(direction) {
            case NORTH:
                return new Position(position.getX(), position.getY() + 1);
            case SOUTH:
                return new Position(position.getX(), position.getY() - 1);
            case EAST:
                return new Position(position.getX() + 1, position.getY());
            case WEST:
                return new Position(position.getX() - 1, position.getY());
            default:
                return position;
        }
    }
}

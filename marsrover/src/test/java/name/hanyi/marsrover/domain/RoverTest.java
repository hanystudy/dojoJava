package name.hanyi.marsrover.domain;

import name.hanyi.marsrover.exception.InvalidMarsPositionException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RoverTest {

    private Rover rover;

    @Before
    public void setUp() {
        rover = new Rover(5, 5, "N");
    }

    @Test
    public void getPositionAndDirectionForRover() {
        assertThat(rover.getPosition(), is(new Position(5, 5)));
        assertThat(rover.getDirection(), is(Direction.NORTH));
    }

    @Test
    public void shouldBeTurnable() {
        rover.turnRight();
        assertThat(rover.getDirection(), is(Direction.EAST));
        rover.turnLeft();
        assertThat(rover.getDirection(), is(Direction.NORTH));
    }

    @Test
    public void shouldBeMovable() {
        try {
            rover.stepForward();
        } catch (InvalidMarsPositionException e) {
            e.printStackTrace();
        }
        assertThat(rover.getPosition(), is(new Position(5, 6)));
        assertThat(rover.getDirection(), is(Direction.NORTH));
    }
}

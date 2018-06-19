package name.hanyi.marsrover.domain;

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
}

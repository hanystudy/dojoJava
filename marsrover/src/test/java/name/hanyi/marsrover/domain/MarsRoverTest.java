package name.hanyi.marsrover.domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MarsRoverTest {

    private Rover rover;
    private Mars mars;

    @Before
    public void setUp() {
        mars = new Mars(5, 5);
        rover = new Rover(mars, 5, 5, "N");
    }

    @Test
    public void stopAtSamePositionIfRoverCanNotForward() {
        rover.stepForward();
        assertThat(rover.getPosition(), is(new Position(5, 5)));
        assertThat(rover.getDirection(), is(Direction.NORTH));
    }
}

package name.hanyi.marsrover;

import name.hanyi.marsrover.domain.Direction;
import name.hanyi.marsrover.domain.Mars;
import name.hanyi.marsrover.domain.Position;
import name.hanyi.marsrover.domain.Rover;
import name.hanyi.marsrover.exception.InvalidMarsPositionException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MarsRoverTest {

    private Rover rover;
    private Mars mars;
    private MarsRover marsRover;

    @Before
    public void setUp() {
        mars = new Mars(5, 5);
        rover = new Rover(mars, 5, 5, "N");
        marsRover = new MarsRover();
    }

    @Test
    public void stopAtSamePositionIfRoverCanNotForward() {
        try {
            rover.stepForward();
        } catch (InvalidMarsPositionException e) {
            e.printStackTrace();
        }
        assertThat(rover.getPosition(), is(new Position(5, 5)));
        assertThat(rover.getDirection(), is(Direction.NORTH));
    }

    @Test
    public void shouldRunViaCommandsContainL() {
        marsRover.buildMars("5 5");
        marsRover.buildRover("1 2 N");
        try {
            marsRover.runRover("LMLMLMLMM");
        } catch (InvalidMarsPositionException e) {
            e.printStackTrace();
        }
        assertThat(marsRover.getRoverLocation(), is(new Position(1, 3)));
        assertThat(marsRover.getRoverDirection(), is(Direction.NORTH));
    }

    @Test
    public void shouldRunViaCommandsContainR() {
        marsRover.buildMars("5 5");
        marsRover.buildRover("3 3 E");
        try {
            marsRover.runRover("MMRMMRMRRM");
        } catch (InvalidMarsPositionException e) {
            e.printStackTrace();
        }
        assertThat(marsRover.getRoverLocation(), is(new Position(5, 1)));
        assertThat(marsRover.getRoverDirection(), is(Direction.EAST));
    }
}

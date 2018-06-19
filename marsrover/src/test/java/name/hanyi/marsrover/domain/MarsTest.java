package name.hanyi.marsrover.domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MarsTest {

    private Mars mars;

    @Before
    public void setUp() {
        mars = new Mars(5, 5);
    }

    @Test
    public void shouldReturnFalseIfPositionIsInvalid() {
        assertThat(mars.validPosition(new Position(6, 0)), is(false));
    }
}


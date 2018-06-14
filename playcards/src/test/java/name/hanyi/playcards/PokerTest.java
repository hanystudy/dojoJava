package name.hanyi.playcards;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class PokerTest {
    private Poker poker;

    @Before
    public void setUp() {
        this.poker = new Poker();
    }

    @Test
    public void getFiftyTwoPlayCards() {
        assertThat(this.poker.getALlPlayCards().size(), is(52));
    }
}

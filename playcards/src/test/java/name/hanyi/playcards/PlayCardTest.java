package name.hanyi.playcards;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PlayCardTest {

    PlayCard playCard;

    @Before
    public void setUp() {
        playCard = new PlayCard("Ace", "Hearts");
    }

    @Test
    public void getRankAndSuitForPlayCard() {
        assertThat(playCard.getRanks(), is("Ace"));
        assertThat(playCard.getSuits(), is("Hearts"));
    }
}

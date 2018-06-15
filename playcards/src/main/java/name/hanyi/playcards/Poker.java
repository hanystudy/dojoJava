package name.hanyi.playcards;

import java.util.ArrayList;
import java.util.List;

public class Poker {
    private List<PlayCard> playCards;

    public Poker() {
        this.playCards = new ArrayList<>(52);
        for(Suit suit : Suit.values()) {
            for(Rank rank : Rank.values()) {
                this.playCards.add(new PlayCard(rank.getName(), suit.getName()));
            }
        }
    }

    public List<PlayCard> getALlPlayCards() {
        return this.playCards;
    }
}

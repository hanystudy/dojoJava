package name.hanyi.playcards;

import java.util.ArrayList;
import java.util.List;

public class Poker {
    private List<PlayCard> playCards;

    private String[] SUITS = {"Hearts", "Diamonds", "Clubs", "Spades"};
    private String[] RANKS = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

    public Poker() {
        this.playCards = new ArrayList<>(52);
        for(String suit : SUITS) {
            for(String rank : RANKS) {
                this.playCards.add(new PlayCard(rank, suit));
            }
        }
    }

    public List<PlayCard> getALlPlayCards() {
        return this.playCards;
    }
}

import name.hanyi.playcards.PlayCard;
import name.hanyi.playcards.Poker;

public class PlayCardsMain {
    public static void main(String[] args) {
        Poker poker = new Poker();
        for(PlayCard playCard : poker.getALlPlayCards()) {
            System.out.println(playCard.getRanks() + " " + playCard.getSuits());
        }
    }
}

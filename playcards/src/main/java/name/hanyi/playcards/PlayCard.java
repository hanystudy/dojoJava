package name.hanyi.playcards;

public class PlayCard {
    private String suits;
    private String ranks;

    public PlayCard(String ranks, String suits) {
        this.suits = suits;
        this.ranks = ranks;
    }

    public String getSuits() {
        return suits;
    }

    public String getRanks() {
        return ranks;
    }
}

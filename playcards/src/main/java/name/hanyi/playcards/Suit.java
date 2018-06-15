package name.hanyi.playcards;

public enum Suit {
    HEARTS("Hearts"),
    DIAMONDS("Diamonds"),
    CLUBS("Clubs"),
    SPADES("Spades");

    private String name;

    Suit(String name) {
       this.name = name;
    }

    public String getName() {
        return name;
    }
}

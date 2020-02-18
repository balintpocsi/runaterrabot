package Cards;

import java.util.List;

public class Deck {

    List<Card> deckList;

    public Deck(List<Card> deckList) {
        this.deckList = deckList;
    }

    public List<Card> getDeckList() {
        return deckList;
    }

    public void setDeckList(List<Card> deckList) {
        this.deckList = deckList;
    }
}

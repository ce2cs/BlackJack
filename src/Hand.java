import java.util.ArrayList;

public class Hand extends Deck {
    Hand() {
        super.deck = new ArrayList<Card>();
    }

    // Returns the best possible value of the hand
    // If the hand is bust, returns -1
    int getValue() {
        int value = 0;
        int aces = 0;
        for (Card card : deck) {
            if (card.getRank() == 1) {
                aces++;
                continue;
            }
            if (card.getRank() > 10) {
                value += 10;
            }
            if (card.getRank() <= 10) {
                value += card.getRank();
            }
        }
        return getBest(value, aces);
    }

    int getBest(int base, int aces) {
        if (base > 21) {
            return -1;
        }
        if (aces == 0) {
            return base;
        }
        int best = -1;
        if (base + 1 > 21) {
            return best;
        } else if (base + 11 > 21) {
            best = Math.max(getBest(base + 1, aces - 1), best);
        } else {
            best = Math.max(getBest(base + 11, aces - 1), best);
            best = Math.max(getBest(base + 1, aces - 1), best);
        }
        return best;
    }

    void hideOneCard() {
        deck.get(0).setFaceUp(false);
    }

    void showOneCard() {
        deck.get(0).setFaceUp(true);
    }
}

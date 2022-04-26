import java.util.ArrayList;

import java.util.Random;

public class Deck {


    protected ArrayList<Card> deck;


    public Deck() {

        deck = new ArrayList<Card>();

        for (int i = 1; i <= 4; i++) {

            for (int j = 1; j <= 13; j++) {

                Card card = new Card(i, j);

                deck.add(card);

            }

        }

    }


    public void shuffle() {

        ArrayList<Card> tmp = new ArrayList<Card>();

        Random rand = new Random();

        while (!deck.isEmpty()) {


            int index = rand.nextInt(deck.size());

            tmp.add(deck.remove(index));


        }


        deck = tmp;

    }


    public String toString() {

        String str = "";

        for (int i = 0; i < deck.size(); i++)

            str += deck.get(i).toString() + "\t";

        return str;

    }


    public void addCard(Card card) {

        deck.add(card);

    }


    public Card removeCard() {

        if (!deck.isEmpty())

            return deck.remove(0);

        return null;

    }


    public void sort() {

        int min;

        for (int i = 0; i < deck.size() - 1; i++) {

            min = i;

            for (int j = i + 1; j < deck.size(); j++) {

                if (deck.get(j).getRank() < deck.get(min).getRank())


                    min = j;

            }


            if (min != i) {

                Card tmp = deck.remove(min);

                deck.add(i, tmp);

                tmp = deck.remove(i + 1);

                deck.add(tmp);

            }

        }

    }
}

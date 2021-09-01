package org.csystem.games.cardgames;

public class CardTest {
    private CardTest()
    {
    }

    public static void run()
    {
        Card[] deck;

        deck = Card.getShuffledDeck();

        for (Card c : deck)
            System.out.println(c);
    }
}

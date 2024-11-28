package sdm.running.example;

import org.junit.jupiter.api.Test;
import sdm.running.example.card.Card;
import sdm.running.example.card.Rank;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Nobs {

    @Test
    void inHand() {
        CribbageHand hand = new CribbageHand(
                Arrays.asList(
                        new Card(Rank.EIGHT, '♥'),
                        new Card(Rank.JACK, '♣'),
                        new Card(Rank.SIX, '♠'),
                        new Card(Rank.KING, '♣')
                ),
                new Card(Rank.THREE, '♣')
        );
        assertTrue(hand.hasNobs());
    }

    @Test
    void notInHand() {
        CribbageHand hand = new CribbageHand(
                Arrays.asList(
                        new Card(Rank.EIGHT, '♥'),
                        new Card(Rank.JACK, '♥'),
                        new Card(Rank.SIX, '♠'),
                        new Card(Rank.KING, '♣')
                ),
                new Card(Rank.THREE, '♣')
        );
        assertFalse(hand.hasNobs());
    }
}

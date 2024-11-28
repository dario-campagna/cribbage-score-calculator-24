package sdm.running.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CribbagePairs {

    @Test
    void withOnePair() {
        CribbageHand hand = new CribbageHand(
                Arrays.asList(
                        new Card(Rank.EIGHT, '♥'),
                        new Card(Rank.EIGHT, '♦'),
                        new Card(Rank.FOUR, '♠'),
                        new Card(Rank.ACE, '♣')
                ),
        new Card(Rank.FIVE, '♣')
        );
        assertEquals(1, hand.getNumberOfPairs());
    }

    @Test
    void withThreePairs() {
        CribbageHand hand = new CribbageHand(
                Arrays.asList(
                        new Card(Rank.TWO, '♥'),
                        new Card(Rank.TWO, '♦'),
                        new Card(Rank.TWO, '♠'),
                        new Card(Rank.ACE, '♣')
                ),
                new Card(Rank.FIVE, '♣')
        );
        assertEquals(3, hand.getNumberOfPairs());
    }

    @Test
    void withSixPair() {
        CribbageHand hand = new CribbageHand(
                Arrays.asList(
                        new Card(Rank.THREE, '♥'),
                        new Card(Rank.THREE, '♦'),
                        new Card(Rank.THREE, '♠'),
                        new Card(Rank.ACE, '♣')
                ),
                new Card(Rank.THREE, '♣')
        );
        assertEquals(6, hand.getNumberOfPairs());
    }
}

package sdm.running.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Score {

    @Test
    void oneForTheNobs() {
        CribbageHand hand = new CribbageHand(
                Arrays.asList(
                        new Card(Rank.EIGHT, '♥'),
                        new Card(Rank.JACK, '♣'),
                        new Card(Rank.SIX,'♠'),
                        new Card(Rank.KING, '♣')
                ),
                new Card(Rank.THREE, '♣')
        );
        assertEquals(1, hand.score());
    }

    @Test
    void zero() {
        CribbageHand hand = new CribbageHand(
                Arrays.asList(
                        new Card(Rank.EIGHT, '♥'),
                        new Card(Rank.KING, '♥'),
                        new Card(Rank.JACK, '♠'),
                        new Card(Rank.ACE, '♣')
                ),
                new Card(Rank.THREE, '♣')
        );
        assertEquals(0, hand.score());
    }

    @Test
    void twoForOneFifteenTwos() {
        CribbageHand hand = new CribbageHand(
                Arrays.asList(
                        new Card(Rank.EIGHT, '♥'),
                        new Card(Rank.JACK, '♣'),
                        new Card(Rank.FOUR, '♠'),
                        new Card(Rank.KING, '♣')
                ),
                new Card(Rank.THREE, '♠')
        );
        assertEquals(2, hand.score());
    }

    @Test
    void sixForThreeFifteenTwos() {
        CribbageHand hand = new CribbageHand(
                Arrays.asList(
                        new Card(Rank.SEVEN, '♦'),
                        new Card(Rank.THREE, '♦'),
                        new Card(Rank.TEN, '♥'),
                        new Card(Rank.FIVE,'♣')
                ),
                new Card(Rank.TWO, '♥')
        );
        assertEquals(6, hand.score());
    }

    @Test
    void twoForOnePair() {
        CribbageHand hand = new CribbageHand(
                Arrays.asList(
                        new Card(Rank.EIGHT, '♥'),
                        new Card(Rank.EIGHT, '♦'),
                        new Card(Rank.FOUR, '♠'),
                        new Card(Rank.ACE, '♣')
                ),
                new Card(Rank.FIVE, '♣')
        );
        assertEquals(2, hand.score());
    }

    @Test
    void sixForThreePairs() {
        CribbageHand hand = new CribbageHand(
                Arrays.asList(
                        new Card(Rank.TWO, '♥'),
                        new Card(Rank.TWO, '♦'),
                        new Card(Rank.TWO, '♠'),
                        new Card(Rank.ACE, '♣')
                ),
                new Card(Rank.FIVE, '♣')
        );
        assertEquals(6, hand.score());
    }

    @Test
    void twelveForSixPairs() {
        CribbageHand hand = new CribbageHand(
                Arrays.asList(
                        new Card(Rank.THREE, '♥'),
                        new Card(Rank.THREE, '♦'),
                        new Card(Rank.THREE, '♠'),
                        new Card(Rank.ACE, '♣')
                ),
                new Card(Rank.THREE, '♣')
        );
        assertEquals(12, hand.score());
    }
}

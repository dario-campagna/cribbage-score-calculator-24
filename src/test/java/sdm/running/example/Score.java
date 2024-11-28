package sdm.running.example;

import org.junit.jupiter.api.Test;
import sdm.running.example.card.Card;
import sdm.running.example.card.Rank;
import sdm.running.example.rules.ScoreForFifteenTwos;
import sdm.running.example.rules.ScoreForFlush;
import sdm.running.example.rules.ScoreForNobs;
import sdm.running.example.rules.ScoreForPairs;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Score {

    private final CribbageScore cribbageScore = new CribbageScore(Arrays.asList(
            new ScoreForPairs(),
            new ScoreForFlush(),
            new ScoreForNobs(),
            new ScoreForFifteenTwos()
    ));

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
        assertEquals(1, cribbageScore.of(hand));
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
        assertEquals(0, cribbageScore.of(hand));
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
        assertEquals(2, cribbageScore.of(hand));
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
        assertEquals(6, cribbageScore.of(hand));
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
        assertEquals(2, cribbageScore.of(hand));
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
        assertEquals(6, cribbageScore.of(hand));
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
        assertEquals(12, cribbageScore.of(hand));
    }

    @Test
    void twentyNineFor8FifteenTwos6PairsAndNobs() {
        CribbageHand hand = new CribbageHand(
                Arrays.asList(
                        new Card(Rank.FIVE, '♥'),
                        new Card(Rank.FIVE, '♦'),
                        new Card(Rank.FIVE, '♠'),
                        new Card(Rank.JACK, '♣')
                ),
                new Card(Rank.FIVE, '♣')
        );
        assertEquals(29, cribbageScore.of(hand));
    }
}

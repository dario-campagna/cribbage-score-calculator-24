package sdm.running.example;

import org.junit.jupiter.api.Test;
import sdm.running.example.card.Card;
import sdm.running.example.card.Rank;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RunsInHand {

    @Test
    void oneRunOfThree() {
        CribbageHand hand = new CribbageHand(
                Arrays.asList(
                        new Card(Rank.TEN, '♦'),
                        new Card(Rank.JACK, '♥'),
                        new Card(Rank.QUEEN, '♠'),
                        new Card(Rank.ACE,'♣')
                ),
                new Card(Rank.TWO, '♦')
        );
        assertEquals(1, hand.runsOfThree());
    }

    @Test
    void twoRunsOfThree() {
        CribbageHand hand = new CribbageHand(
                Arrays.asList(
                        new Card(Rank.TEN, '♦'),
                        new Card(Rank.JACK, '♥'),
                        new Card(Rank.QUEEN, '♠'),
                        new Card(Rank.TEN,'♣')
                ),
                new Card(Rank.FOUR, '♦')
        );
        assertEquals(2, hand.runsOfThree());
    }

    @Test
    void oneRunOfFour() {
        CribbageHand hand = new CribbageHand(
                Arrays.asList(
                        new Card(Rank.TEN, '♦'),
                        new Card(Rank.JACK, '♥'),
                        new Card(Rank.QUEEN, '♠'),
                        new Card(Rank.ACE,'♣')
                ),
                new Card(Rank.NINE, '♦')
        );
        assertEquals(1, hand.runsOfFour());
    }

    @Test
    void twoRunsOfFour() {
        CribbageHand hand = new CribbageHand(
                Arrays.asList(
                        new Card(Rank.TEN, '♦'),
                        new Card(Rank.JACK, '♥'),
                        new Card(Rank.QUEEN, '♠'),
                        new Card(Rank.NINE,'♣')
                ),
                new Card(Rank.NINE, '♦')
        );
        assertEquals(2, hand.runsOfFour());
    }

    @Test
    void oneRunOfFive() {
        CribbageHand hand = new CribbageHand(
                Arrays.asList(
                        new Card(Rank.FIVE, '♠'),
                        new Card(Rank.FOUR, '♠'),
                        new Card(Rank.TWO, '♠'),
                        new Card(Rank.SIX, '♥')
                ),
                new Card(Rank.THREE, '♥')
        );
        assertTrue(hand.isRunOfFive());
    }
}

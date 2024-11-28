package sdm.running.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class Flush {

    @Test
    void notFlush() {
        CribbageHand hand = new CribbageHand(
                Arrays.asList(
                        new Card(Rank.TEN, '♥'),
                        new Card(Rank.JACK, '♦'),
                        new Card(Rank.KING, '♥'),
                        new Card(Rank.ACE,'♥')
                ),
                new Card(Rank.NINE, '♦')
        );
        assertFalse(hand.isFlush());
    }

    @Test
    void flushWithDifferentStarterCardSuite() {
        CribbageHand hand = new CribbageHand(
                Arrays.asList(
                        new Card(Rank.TEN, '♥'),
                        new Card(Rank.JACK, '♥'),
                        new Card(Rank.KING, '♥'),
                        new Card(Rank.ACE,'♥')
                ),
                new Card(Rank.NINE, '♦')
        );
        assertTrue(hand.isFlush());
    }

    @Test
    void allSameSuite() {
        CribbageHand hand = new CribbageHand(
                Arrays.asList(
                        new Card(Rank.TEN, '♥'),
                        new Card(Rank.JACK, '♥'),
                        new Card(Rank.KING, '♥'),
                        new Card(Rank.ACE,'♥')
                ),
                new Card(Rank.NINE, '♥')
        );
        assertTrue(hand.hasCardsOfSameSuite());
    }
}

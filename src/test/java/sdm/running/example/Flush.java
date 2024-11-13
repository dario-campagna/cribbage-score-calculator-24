package sdm.running.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Flush {

    @Test
    void testFlushWithDifferentStarterCardSuite() {
        CribbageHand hand = new CribbageHand(
                Arrays.asList(
                        new Card(Rank.TEN, '♥'),
                        new Card(Rank.JACK, '♥'),
                        new Card(Rank.KING, '♥'),
                        new Card(Rank.ACE,'♥')
                ),
                new Card(Rank.NINE, '♦')
        );
        assertEquals(4, hand.score());
    }

    @Test
    void testFlushWithSameStarterCardSuite() {
        CribbageHand hand = new CribbageHand(
                Arrays.asList(
                        new Card(Rank.TEN, '♥'),
                        new Card(Rank.JACK, '♥'),
                        new Card(Rank.KING, '♥'),
                        new Card(Rank.ACE,'♥')
                ),
                new Card(Rank.NINE, '♥')
        );
        assertEquals(6, hand.score());
    }
}

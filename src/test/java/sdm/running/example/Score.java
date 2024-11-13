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
}

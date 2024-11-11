package sdm.running.example;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CribbagePairs {

    @Test
    void withOnePair() {
        CribbageHand hand = new CribbageHand(
                Arrays.asList(
                        new Card('8', '♥'),
                        new Card('8', '♦'),
                        new Card('4', '♠'),
                        new Card('A', '♣')
                ),
        new Card('5', '♣')
        );
        assertEquals(2, hand.pairs());
    }

    @Test
    void withThreePairs() {
        CribbageHand hand = new CribbageHand(
                Arrays.asList(
                        new Card('2', '♥'),
                        new Card('2', '♦'),
                        new Card('2', '♠'),
                        new Card('A', '♣')
                ),
                new Card('5', '♣')
        );
        assertEquals(6, hand.pairs());
    }

    @Test
    void withSixPair() {
        CribbageHand hand = new CribbageHand(
                Arrays.asList(
                        new Card('3', '♥'),
                        new Card('3', '♦'),
                        new Card('3', '♠'),
                        new Card('A', '♣')
                ),
                new Card('3', '♣')
        );
        assertEquals(12, hand.pairs());
    }
}

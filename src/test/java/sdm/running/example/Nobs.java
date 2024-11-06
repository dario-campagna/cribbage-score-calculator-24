package sdm.running.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class Nobs {

    @Test
    void inHand() {
        CribbageHand hand = new CribbageHand(
                Arrays.asList(
                        new Card('8', '♥'),
                        new Card('J', '♣'),
                        new Card('6', '♠'),
                        new Card('K', '♣')
                ),
                new Card('3', '♣')
        );
        assertTrue(hand.hasNobs());
    }

    @Test
    void notInHand() {
        CribbageHand hand = new CribbageHand(
                Arrays.asList(
                        new Card('8', '♥'),
                        new Card('J', '♥'),
                        new Card('6', '♠'),
                        new Card('K', '♣')
                ),
                new Card('3', '♣')
        );
        assertFalse(hand.hasNobs());
    }
}

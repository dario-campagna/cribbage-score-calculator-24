package sdm.running.example;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Flush {

    @Test
    void flushWithDifferentStarter() {
        CribbageHand hand = new CribbageHand(
                Arrays.asList(
                        new Card('0', '♥'),
                        new Card('J', '♥'),
                        new Card('K', '♥'),
                        new Card('A', '♥')
                ),
                new Card('9', '♦')
        );
        assertEquals(4, hand.flush());
    }

    @Test
    void flushWithSameStarter() {
        CribbageHand hand = new CribbageHand(
                Arrays.asList(
                        new Card('0', '♥'),
                        new Card('J', '♥'),
                        new Card('K', '♥'),
                        new Card('A', '♥')
                ),
                new Card('9', '♥')
        );
        assertEquals(5, hand.flush());
    }
}

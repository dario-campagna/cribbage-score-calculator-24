package sdm.running.example;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RunsInHand {

    @Test
    @Disabled
    void oneRunOfFour() {
        CribbageHand hand = new CribbageHand(
                Arrays.asList(
                        new Card('0', '♦'),
                        new Card('J', '♥'),
                        new Card('Q', '♠'),
                        new Card('A', '♣')
                ),
                new Card('9', '♦')
        );
        assertEquals(1, hand.runsOfFour());
    }
}

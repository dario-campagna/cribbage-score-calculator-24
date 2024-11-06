package sdm.running.example;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FifteenTwosInHand {

    @Test
    @Disabled
    void oneCombinationOfThreeCards() {
        CribbageHand hand = new CribbageHand(
                Arrays.asList(
                        new Card('8', '♥'),
                        new Card('J', '♣'),
                        new Card('4', '♠'),
                        new Card('K', '♣')
                ),
                new Card('3', '♣')
        );
        assertEquals(1, hand.fifteenTwos());
    }
}

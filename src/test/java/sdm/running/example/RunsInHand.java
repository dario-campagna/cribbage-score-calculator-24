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
                        new Card(Rank.TEN, '♦'),
                        new Card(Rank.JACK, '♥'),
                        new Card(Rank.QUEEN, '♠'),
                        new Card(Rank.ACE,'♣')
                ),
                new Card(Rank.NINE, '♦')
        );
        assertEquals(1, hand.runsOfFour());
    }
}

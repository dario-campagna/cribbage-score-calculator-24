package sdm.running.example;

import org.junit.jupiter.api.Test;
import sdm.running.example.card.Card;
import sdm.running.example.card.Rank;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FifteenTwosInHand {

    @Test
    void oneCombinationOfThreeCards() {
        CribbageHand hand = new CribbageHand(
                Arrays.asList(
                        new Card(Rank.EIGHT, '♥'),
                        new Card(Rank.JACK, '♣'),
                        new Card(Rank.FOUR, '♠'),
                        new Card(Rank.KING, '♣')
                ),
                new Card(Rank.THREE, '♣')
        );
        assertEquals(1, hand.fifteenTwos());
    }

    @Test
    void threeCombinationsOfThreeCards() {
        CribbageHand hand = new CribbageHand(
                Arrays.asList(
                        new Card(Rank.SEVEN, '♦'),
                        new Card(Rank.THREE, '♦'),
                        new Card(Rank.TEN, '♥'),
                        new Card(Rank.FIVE,'♣')
                ),
                new Card(Rank.THREE, '♥')
        );
        assertEquals(3, hand.fifteenTwos());
    }
}

package sdm.running.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParseCribbageHand {

    private final CribbageHandParser cribbageHandParser = new CribbageHandParser();

    @Test
    void withStarterCardFiveOfClubs() {
        CribbageHand cribbageHand = cribbageHandParser.parse("5♥5♦5♠J♣5♣");
        assertEquals(new Card(Rank.FIVE, '♣'), cribbageHand.starterCard());
    }

    @Test
    void withStarterCardAceOfSpades() {
        CribbageHand cribbageHand = cribbageHandParser.parse("5♥5♦5♠J♣A♠");
        assertEquals(new Card(Rank.ACE, '♠'), cribbageHand.starterCard());
    }

    @Test
    void withHandCardsFiveOfEachSuite() {
        CribbageHand cribbageHand = cribbageHandParser.parse("5♥5♦5♠5♣A♠");
        Card[] expectedHandCards = {
                new Card(Rank.FIVE, '♥'),
                new Card(Rank.FIVE, '♦'),
                new Card(Rank.FIVE, '♠'),
                new Card(Rank.FIVE, '♣')
        };
        assertArrayEquals(expectedHandCards, cribbageHand.handCards());
    }

    @Test
    void withHandCardsThreeOfEachSuite() {
        CribbageHand cribbageHand = cribbageHandParser.parse("3♥3♦3♠3♣A♠");
        Card[] expectedHandCards = {
                new Card(Rank.THREE, '♥'),
                new Card(Rank.THREE, '♦'),
                new Card(Rank.THREE, '♠'),
                new Card(Rank.THREE, '♣')
        };
        assertArrayEquals(expectedHandCards, cribbageHand.handCards());
    }

    @Test
    void withHandCardsAceOfEachSuiteAndStarterCardKingOfHearts() {
        CribbageHand cribbageHand = cribbageHandParser.parse("A♥A♦A♠A♣K♥");
        CribbageHand expectedHand = new CribbageHand(
                Arrays.asList(
                        new Card(Rank.ACE, '♥'),
                        new Card(Rank.ACE, '♦'),
                        new Card(Rank.ACE, '♠'),
                        new Card(Rank.ACE, '♣')
                ),
                new Card(Rank.KING, '♥')
        );
        assertEquals(expectedHand, cribbageHand);
    }
}

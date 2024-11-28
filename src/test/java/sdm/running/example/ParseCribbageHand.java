package sdm.running.example;

import org.junit.jupiter.api.Test;
import sdm.running.example.card.Card;
import sdm.running.example.card.Rank;
import sdm.running.example.parse.CribbageHandParser;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParseCribbageHand {

    private final CribbageHandParser cribbageHandParser = new CribbageHandParser();

    @Test
    void withHandCardsFiveOfEachSuiteAndStarterCardAceOfSpades() {
        List<Card> expectedHandCards = Arrays.asList(
                new Card(Rank.FIVE, '♥'),
                new Card(Rank.FIVE, '♦'),
                new Card(Rank.FIVE, '♠'),
                new Card(Rank.FIVE, '♣')
        );
        CribbageHand expectedHand = new CribbageHand(expectedHandCards, new Card(Rank.ACE, '♠'));
        CribbageHand cribbageHand = cribbageHandParser.parse("5♥5♦5♠5♣A♠");
        assertEquals(expectedHand, cribbageHand);
    }

    @Test
    void withHandCardsThreeOfEachSuiteAndStarterCardAceOfSpades() {
        List<Card> expectedHandCards = Arrays.asList(
                new Card(Rank.THREE, '♥'),
                new Card(Rank.THREE, '♦'),
                new Card(Rank.THREE, '♠'),
                new Card(Rank.THREE, '♣')
        );
        CribbageHand expectedHand = new CribbageHand(expectedHandCards, new Card(Rank.ACE, '♠'));
        CribbageHand cribbageHand = cribbageHandParser.parse("3♥3♦3♠3♣A♠");
        assertEquals(expectedHand, cribbageHand);
    }

    @Test
    void withHandCardsAceOfEachSuiteAndStarterCardKingOfHearts() {
        CribbageHand expectedHand = new CribbageHand(
                Arrays.asList(
                        new Card(Rank.ACE, '♥'),
                        new Card(Rank.ACE, '♦'),
                        new Card(Rank.ACE, '♠'),
                        new Card(Rank.ACE, '♣')
                ),
                new Card(Rank.KING, '♥')
        );
        CribbageHand cribbageHand = cribbageHandParser.parse("A♥A♦A♠A♣K♥");
        assertEquals(expectedHand, cribbageHand);
    }
}

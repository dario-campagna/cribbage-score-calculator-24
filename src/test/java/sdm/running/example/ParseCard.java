package sdm.running.example;

import org.junit.jupiter.api.Test;
import sdm.running.example.card.Card;
import sdm.running.example.card.Rank;
import sdm.running.example.parse.CardParser;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParseCard {

    private final CardParser cardParser = new CardParser();

    @Test
    void withSuiteSpades() {
        Card card = cardParser.parse("5♠");
        assertEquals('♠', card.suite());
    }

    @Test
    void withSuiteHearts() {
        Card card = cardParser.parse("5♥");
        assertEquals('♥', card.suite());
    }

    @Test
    void withSuiteClubs() {
        Card card = cardParser.parse("5♣");
        assertEquals('♣', card.suite());
    }

    @Test
    void withSuiteDiamonds() {
        Card card = cardParser.parse("5♦");
        assertEquals('♦', card.suite());
    }

    @Test
    void withRankFive() {
        Card card = cardParser.parse("5♦");
        assertEquals(Rank.FIVE, card.rank());
    }
}

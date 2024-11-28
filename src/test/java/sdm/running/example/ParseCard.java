package sdm.running.example;

import org.junit.jupiter.api.Test;
import sdm.running.example.card.Card;
import sdm.running.example.card.Rank;
import sdm.running.example.parse.CardParser;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParseCard {

    private final CardParser cardParser = new CardParser();

    @Test
    void withSuiteSpades() {
        Card card = cardParser.parse("5♠");
        assertTrue(card.hasSameSuiteAs(new Card(Rank.EIGHT, '♠')));
    }

    @Test
    void withSuiteHearts() {
        Card card = cardParser.parse("5♥");
        assertTrue(card.hasSameSuiteAs(new Card(Rank.TEN, '♥')));
    }

    @Test
    void withSuiteClubs() {
        Card card = cardParser.parse("5♣");
        assertTrue(card.hasSameSuiteAs(new Card(Rank.SEVEN, '♣')));
    }

    @Test
    void withSuiteDiamonds() {
        Card card = cardParser.parse("5♦");
        assertTrue(card.hasSameSuiteAs(new Card(Rank.TWO, '♦')));
    }

    @Test
    void withRankFive() {
        Card card = cardParser.parse("5♦");
        assertTrue(card.hasSameRankAs(new Card(Rank.FIVE, '♣')));
    }
}

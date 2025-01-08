package sdm.running.example;

import org.junit.jupiter.api.Test;
import sdm.running.example.card.Card;
import sdm.running.example.card.Rank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CardComparison {

    @Test
    void aceIsLessThanTwo() {
        assertEquals(-1, new Card(Rank.ACE, '♦').compareTo(new Card(Rank.TWO, '♦')));
    }

    @Test
    void twoIsLessThanThree() {
        assertEquals(-1, new Card(Rank.TWO, '♦').compareTo(new Card(Rank.THREE, '♦')));
    }

    @Test
    void threeIsLessThanFour() {
        assertEquals(-1, new Card(Rank.THREE, '♦').compareTo(new Card(Rank.FOUR, '♦')));
    }

    @Test
    void fourIsLessThanFive() {
        assertEquals(-1, new Card(Rank.FOUR, '♦').compareTo(new Card(Rank.FIVE, '♦')));
    }

    @Test
    void fiveIsLessThanSix() {
        assertEquals(-1, new Card(Rank.FIVE, '♦').compareTo(new Card(Rank.SIX, '♦')));
    }

    @Test
    void sixIsLessThanSeven() {
        assertEquals(-1, new Card(Rank.SIX, '♦').compareTo(new Card(Rank.SEVEN, '♦')));
    }

    @Test
    void sevenIsLessThanEight() {
        assertEquals(-1, new Card(Rank.SEVEN, '♦').compareTo(new Card(Rank.EIGHT, '♦')));
    }

    @Test
    void eightIsLessThanNine() {
        assertEquals(-1, new Card(Rank.EIGHT, '♦').compareTo(new Card(Rank.NINE, '♦')));
    }

    @Test
    void nineIsLessThanTen() {
        assertEquals(-1, new Card(Rank.NINE, '♦').compareTo(new Card(Rank.TEN, '♦')));
    }

    @Test
    void tenIsLessThanJack() {
        assertEquals(-1, new Card(Rank.TEN, '♦').compareTo(new Card(Rank.JACK, '♦')));
    }

    @Test
    void jackIsLessThanQueen() {
        assertEquals(-1, new Card(Rank.JACK, '♦').compareTo(new Card(Rank.QUEEN, '♦')));
    }

    @Test
    void queenIsLessThanKing() {
        assertEquals(-1, new Card(Rank.QUEEN, '♦').compareTo(new Card(Rank.KING, '♦')));
    }
}

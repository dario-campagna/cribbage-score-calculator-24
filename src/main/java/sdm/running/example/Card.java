package sdm.running.example;

import java.util.HashMap;
import java.util.Map;

public class Card {

    private static final Map<Character, Integer> rankToValue = new HashMap<>(){{
        put('3', 3);
        put('4', 4);
        put('5', 5);
        put('7', 7);
        put('8', 8);
        put('0', 10);
        put('J', 10);
        put('K', 10);
    }};
    
    private final Character suite;
    private final Character rank;

    public Card(Character rank, Character suite) {
        this.rank = rank;
        this.suite = suite;
    }

    public Character suite() {
        return suite;
    }

    public Character rank() {
        return rank;
    }

    public int value() {
        return rankToValue.get(rank);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card card)) return false;

        return suite.equals(card.suite) && rank.equals(card.rank);
    }

    @Override
    public int hashCode() {
        int result = suite.hashCode();
        result = 31 * result + rank.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "" + rank + suite;
    }
}

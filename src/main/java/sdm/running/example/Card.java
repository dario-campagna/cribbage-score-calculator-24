package sdm.running.example;

public class Card {
    private final Character suite;
    private final Rank rank;
    
    public Card(Rank rank, char suite) {
        this.rank = rank;
        this.suite = suite;
    }

    public Character suite() {
        return suite;
    }

    public Rank rank() {
        return rank;
    }

    public Integer value() {
        return rank.value();
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

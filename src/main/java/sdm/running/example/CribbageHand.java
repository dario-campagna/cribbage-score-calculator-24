package sdm.running.example;

import java.util.List;
import java.util.Optional;

public class CribbageHand {
    private final List<Card> handCards;
    private final Card starterCard;

    public CribbageHand(List<Card> handCards, Card starterCard) {
        this.handCards = handCards;
        this.starterCard = starterCard;
    }

    public Card starterCard() {
        return starterCard;
    }

    public Card[] handCards() {
        return handCards.toArray(new Card[]{});
    }

    public boolean hasNobs() {
        Card nobs = new Card('J', starterCard.suite());
        return handCards.contains(nobs);
    }

    public int runsOfFour() {
        return 0;
    }

    public int fifteenTwos() {
        return 0;
    }

    public int flush() {

        Card firstCard = handCards.get(0);
        int starterValue = 0;

        for (Card currentCard : handCards) {
            if (!currentCard.suite().equals(firstCard.suite())) {
                return 0;
            }
        }

        if (starterCard.suite().equals(firstCard.suite())){
            starterValue += 1;
        }
        return 4 + starterValue;
    }

    public int score() {
        int totalScore = 0;

        int scoreForNobs = hasNobs() ? 1 : 0;
        int scoreForFlush = flush();

        totalScore = scoreForNobs + scoreForFlush;
        return totalScore;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CribbageHand that)) return false;

        return handCards.equals(that.handCards) && starterCard.equals(that.starterCard);
    }

    @Override
    public int hashCode() {
        int result = handCards.hashCode();
        result = 31 * result + starterCard.hashCode();
        return result;
    }
}

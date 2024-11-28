package sdm.running.example;

import org.paukov.combinatorics3.Generator;
import sdm.running.example.card.Card;
import sdm.running.example.card.Rank;

import java.util.ArrayList;
import java.util.List;

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
        Card nobs = new Card(Rank.JACK, starterCard.suite());
        return handCards.contains(nobs);
    }

    public int runsOfFour() {
        return 0;
    }

    public long fifteenTwos() {
        List<Card> allCards = getAllCards();
        return Generator.subset(allCards).simple().stream()
                .filter(
                        cardCombination -> cardCombination.size() > 1 && sumOf(cardCombination) == 15
                ).count();
    }

    private static int sumOf(List<Card> cardCombination) {
        return cardCombination.stream().mapToInt(Card::value).sum();
    }

    public long getNumberOfPairs() {
        List<Card> allCards = getAllCards();
        return Generator.combination(allCards).simple(2).stream().filter(
                cards -> cards.get(0).hasSameRankOf(cards.get(1))
        ).count();
    }

    public boolean isFlush() {
        return handCards.stream().allMatch(card -> card.hasSameSuiteOf(handCards.get(0)));
    }

    public boolean hasCardsOfSameSuite() {
        List<Card> allCards = getAllCards();
        return allCards.stream().allMatch(card -> card.hasSameSuiteOf(allCards.get(0)));
    }

    private List<Card> getAllCards() {
        List<Card> allCards = new ArrayList<>(handCards);
        allCards.add(starterCard);
        return allCards;
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

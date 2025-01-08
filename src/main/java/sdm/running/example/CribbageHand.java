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

    public boolean hasNobs() {
        Card jack = new Card(Rank.JACK, '♠');
        return handCards.stream().anyMatch(card -> card.hasSameRankAs(jack) && card.hasSameSuiteAs(starterCard));
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

    public long numberOfPairs() {
        List<Card> allCards = getAllCards();
        return Generator.combination(allCards).simple(2).stream().filter(
                cards -> cards.get(0).hasSameRankAs(cards.get(1))
        ).count();
    }

    public boolean isFlush() {
        return handCards.stream().allMatch(card -> card.hasSameSuiteAs(handCards.get(0)));
    }

    public boolean hasCardsOfSameSuite() {
        List<Card> allCards = getAllCards();
        return allCards.stream().allMatch(card -> card.hasSameSuiteAs(allCards.get(0)));
    }

    private static int sumOf(List<Card> cardCombination) {
        return cardCombination.stream().mapToInt(Card::value).sum();
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

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

    public long runsOfThree() {
        List<Card> allCards = getAllCards();
        return Generator.subset(allCards).simple().stream()
                .filter(
                        cardCombination -> cardCombination.size() == 3 && isRun(cardCombination)
                ).count();
    }

    public long runsOfFour() {
        List<Card> allCards = getAllCards();
        return Generator.subset(allCards).simple().stream()
                .filter(
                        cardCombination -> cardCombination.size() == 4 && isRun(cardCombination)
                ).count();
    }

    public boolean isRunOfFive() {
        List<Card> allCards = getAllCards();
        return isRun(allCards);
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

    private List<Card> getAllCards() {
        List<Card> allCards = new ArrayList<>(handCards);
        allCards.add(starterCard);
        return allCards;
    }

    private boolean isRun(List<Card> cardCombination) {
        cardCombination.sort(Card::compareTo);
        for (int i = 0; i < cardCombination.size() - 1; i++) {
            if (cardCombination.get(i).compareTo(cardCombination.get(i + 1)) != -1) {
                return false;
            }
        }
        return true;
    }

    private static int sumOf(List<Card> cardCombination) {
        return cardCombination.stream().mapToInt(Card::value).sum();
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

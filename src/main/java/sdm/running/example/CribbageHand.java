package sdm.running.example;

import org.paukov.combinatorics3.Generator;

import java.util.ArrayList;
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
        Card nobs = new Card(Rank.JACK, starterCard.suite());
        return handCards.contains(nobs);
    }

    public int runsOfFour() {
        return 0;
    }

    public long fifteenTwos() {
        List<Card> allCards = new ArrayList<>(handCards);
        allCards.add(starterCard);
        return Generator.subset(allCards).simple().stream()
                .filter(
                        cardCombination -> cardCombination.size() > 1 && sumOf(cardCombination) == 15
                ).count();
    }

    private static int sumOf(List<Card> cardCombination) {
        return cardCombination.stream().mapToInt(Card::value).sum();
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

    public long score() {
        int scoreForNobs = hasNobs() ? 1 : 0;
        int scoreForFlush = flush();
        long scoreForFifteenTwos = 2 * fifteenTwos();

        return scoreForNobs + scoreForFlush + scoreForFifteenTwos;
    }

    public int pointsForPairs() {

        List<Card> allCards = new ArrayList<>(handCards);
        allCards.add(starterCard);
        int numberOfPairs = 0;

        numberOfPairs = getNumberOfPairs(allCards, numberOfPairs);

        return numberOfPairs * 2;
    }

    private static int getNumberOfPairs(List<Card> allCards, int numberOfPairs) {
        for (int i = 0; i < allCards.size() - 1; i++) {
            for (int j = i + 1; j < allCards.size(); j++) {
                Rank a = allCards.get(i).rank();
                Rank b = allCards.get(j).rank();
                if (a == b) {
                    numberOfPairs++;
                }
            }
        }
        return numberOfPairs;
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

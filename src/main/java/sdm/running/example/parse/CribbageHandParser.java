package sdm.running.example.parse;

import sdm.running.example.card.Card;
import sdm.running.example.CribbageHand;

import java.util.ArrayList;
import java.util.List;

public class CribbageHandParser {

    private final CardParser cardParser = new CardParser();

    public CribbageHand parse(String cribbageHandAsString) {
        List<Card> handCards = parseHandCards(cribbageHandAsString);
        Card starterCard = parseStarterCard(cribbageHandAsString);
        return new CribbageHand(handCards, starterCard);
    }

    private List<Card> parseHandCards(String cribbageHandAsString) {
        String handCardsAsString = cribbageHandAsString.substring(0, 8);
        List<Card> handCards = new ArrayList<>();
        for (int i = 0; i < 7; i+=2) {
            String handCard = handCardsAsString.substring(i, i + 2);
            handCards.add(cardParser.parse(handCard));
        }
        return handCards;
    }

    private Card parseStarterCard(String cribbageHandAsString) {
        String starterCardAsString = cribbageHandAsString.substring(8);
        return cardParser.parse(starterCardAsString);
    }
}

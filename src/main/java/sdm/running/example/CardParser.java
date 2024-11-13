package sdm.running.example;

import java.util.HashMap;
import java.util.Map;

public class CardParser {
    private static final Map<Character, Rank> rankByCharacter = new HashMap<>(){{
        put('2', Rank.TWO);
        put('3', Rank.THREE);
        put('4', Rank.FOUR);
        put('5', Rank.FIVE);
        put('6', Rank.SIX);
        put('7', Rank.SEVEN);
        put('8', Rank.EIGHT);
        put('9', Rank.NINE);
        put('0', Rank.TEN);
        put('J', Rank.JACK);
        put('Q', Rank.QUEEN);
        put('K', Rank.KING);
        put('A', Rank.ACE);
    }};
    
    public Card parse(String cardAsString) {
        return new Card(rankByCharacter.get(cardAsString.charAt(0)), cardAsString.charAt(1));
    }
}

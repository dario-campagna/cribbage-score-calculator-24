package sdm.running.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import sdm.running.example.card.Rank;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class RankValue {

    @ParameterizedTest
    @MethodSource("rangeAndValueProvider")
    void isExpectedOne(Rank rank, Integer expectedValue) {
        assertEquals(expectedValue, rank.value());
    }

    public static Stream<Arguments> rangeAndValueProvider() {
        return Stream.of(
                arguments(Rank.ACE, 1),
                arguments(Rank.TWO, 2),
                arguments(Rank.THREE, 3),
                arguments(Rank.FOUR, 4),
                arguments(Rank.FIVE, 5),
                arguments(Rank.SIX, 6),
                arguments(Rank.SEVEN, 7),
                arguments(Rank.EIGHT, 8),
                arguments(Rank.NINE, 9),
                arguments(Rank.TEN, 10),
                arguments(Rank.JACK, 10),
                arguments(Rank.QUEEN, 10),
                arguments(Rank.KING, 10)
        );
    }
}

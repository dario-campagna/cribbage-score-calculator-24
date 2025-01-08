package sdm.running.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import sdm.running.example.card.Rank;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static sdm.running.example.card.Rank.*;

public class RankValue {

    @ParameterizedTest
    @MethodSource("rangeAndValueProvider")
    void isExpectedOne(Rank rank, Integer expectedValue) {
        assertEquals(expectedValue, rank.value());
    }

    public static Stream<Arguments> rangeAndValueProvider() {
        return Stream.of(
                arguments(ACE, 1),
                arguments(TWO, 2),
                arguments(THREE, 3),
                arguments(FOUR, 4),
                arguments(FIVE, 5),
                arguments(SIX, 6),
                arguments(SEVEN, 7),
                arguments(EIGHT, 8),
                arguments(NINE, 9),
                arguments(TEN, 10),
                arguments(JACK, 10),
                arguments(QUEEN, 10),
                arguments(KING, 10)
        );
    }
}

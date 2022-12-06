package fpc.aoc.day5;

import lombok.NonNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class Day5Test {

    public static Stream<Arguments> words() {
        return Stream.of(
            Arguments.of("ugknbfddgicrmopn",true),
            Arguments.of("aaa",true),
            Arguments.of("jchzalrnumimnmhp",false),
            Arguments.of("haegwjzuvuyypxyu",false),
            Arguments.of("dvszwmarrgswjxmb",false)
        );
    }

    @ParameterizedTest
    @MethodSource("words")
    public void testPart1(@NonNull String input, boolean expected) {
        final var actual = Word.of(input).isNicePart1();
        Assertions.assertEquals(expected,actual);
    }


}

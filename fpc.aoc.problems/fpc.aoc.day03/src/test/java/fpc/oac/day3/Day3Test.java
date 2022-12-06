package fpc.oac.day3;

import fpc.aoc.day3.Day3Part1Solver;
import fpc.aoc.day3.Day3Part2Solver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class Day3Test {


  public static Stream<Arguments> samplePart1() {
    return Stream.of(
        Arguments.of(">", 2),
        Arguments.of("^>v<", 4),
        Arguments.of("^v^v^v^v^v", 2)
    );
  }
  public static Stream<Arguments> samplePart2() {
    return Stream.of(
        Arguments.of("^v", 3),
        Arguments.of("^>v<", 3),
        Arguments.of("^v^v^v^v^v", 11)
    );
  }

  @ParameterizedTest
  @MethodSource("samplePart1")
  public void testExamplePart1(String input, int expected) {
    final var actual = new Day3Part1Solver().createProblem(input).solve();
    Assertions.assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("samplePart2")
  public void testExamplePart2(String input, int expected) {
    final var actual = new Day3Part2Solver().createProblem(input).solve();
    Assertions.assertEquals(expected, actual);
  }


}

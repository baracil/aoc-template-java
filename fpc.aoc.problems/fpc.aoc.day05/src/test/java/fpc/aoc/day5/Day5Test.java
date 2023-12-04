package fpc.aoc.day5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day5Test {

  public static final String TEST_INPUT = """
    """;

  @Test
  public void testPart1() {
    final var actual = new Day5Part1Solver().createProblem(TEST_INPUT).solve();
    Assertions.assertEquals("", actual);
  }

  @Test
  public void testPart2() {
    final var actual = new Day5Part2Solver().createProblem(TEST_INPUT).solve();
    Assertions.assertEquals("", actual);
  }

}

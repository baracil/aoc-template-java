package fpc.oac.day2;

import fpc.aoc.day2.Day2Part1Solver;
import fpc.aoc.day2.Day2Part2Solver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day2Test {

  public static final String TEST_INPUT = """
    """;

  @Test
  public void testPart1() {
    final var actual = new Day2Part1Solver().createProblem(TEST_INPUT).solve();
    Assertions.assertEquals("", actual);
  }

  @Test
  public void testPart2() {
    final var actual = new Day2Part2Solver().createProblem(TEST_INPUT).solve();
    Assertions.assertEquals("", actual);
  }

}

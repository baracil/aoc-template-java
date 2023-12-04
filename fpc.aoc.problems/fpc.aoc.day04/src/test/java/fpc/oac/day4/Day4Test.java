package fpc.oac.day4;

import fpc.aoc.day4.Day4Part1Solver;
import fpc.aoc.day4.Day4Part2Solver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day4Test {

  public static final String TEST_INPUT = """
    """;

  @Test
  public void testPart1() {
    final var actual = new Day4Part1Solver().createProblem(TEST_INPUT).solve();
    Assertions.assertEquals("", actual);
  }

  @Test
  public void testPart2() {
    final var actual = new Day4Part2Solver().createProblem(TEST_INPUT).solve();
    Assertions.assertEquals("", actual);
  }


}

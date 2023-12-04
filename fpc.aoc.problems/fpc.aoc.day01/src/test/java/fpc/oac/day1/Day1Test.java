package fpc.oac.day1;

import fpc.aoc.day1.Day1Part1Solver;
import fpc.aoc.day1.Day1Part2Solver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day1Test {


  public static final String TEST_INPUT = """
    """;

  @Test
  public void testPart1() {
    final var actual = new Day1Part1Solver().createProblem(TEST_INPUT).solve();
    Assertions.assertEquals("", actual);
  }

  @Test
  public void testPart2() {
    final var actual = new Day1Part2Solver().createProblem(TEST_INPUT).solve();
    Assertions.assertEquals("", actual);
  }


}

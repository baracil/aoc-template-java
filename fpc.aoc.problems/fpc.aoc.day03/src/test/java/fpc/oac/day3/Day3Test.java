package fpc.oac.day3;

import fpc.aoc.day3.Day3Part1Solver;
import fpc.aoc.day3.Day3Part2Solver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day3Test {


  public static final String TEST_INPUT = """
    """;

  @Test
  public void testPart1() {
    final var actual = new Day3Part1Solver().createProblem(TEST_INPUT).solve();
    Assertions.assertEquals("", actual);
  }

  @Test
  public void testPart2() {
    final var actual = new Day3Part2Solver().createProblem(TEST_INPUT).solve();
    Assertions.assertEquals("", actual);
  }


}

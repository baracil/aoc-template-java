package fpc.aoc.day1;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

public class Day1Part1Solver extends Day1Solver {

  public static AOCProblem<?> provider() {
    return new Day1Part1Solver().createProblem();
  }

  @Override
  public @NonNull Integer solve(@NonNull String input) {
    final var lift = new Lift();
    input.chars().forEach(lift::move);
    return lift.floor();
  }
}

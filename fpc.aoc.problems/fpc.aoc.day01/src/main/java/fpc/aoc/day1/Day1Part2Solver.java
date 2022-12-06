package fpc.aoc.day1;

import fpc.aoc.api.AOCProblem;
import fpc.aoc.common.AOCException;
import lombok.NonNull;

public class Day1Part2Solver extends Day1Solver {

  public static AOCProblem<?> provider() {
    return new Day1Part2Solver().createProblem();
  }

  @Override
  public @NonNull Integer solve(@NonNull String input) {
    final var lift = new Lift();
    for (int i = 0; i < input.length(); i++) {
      lift.move(input.charAt(i));
      if (lift.floor() == -1) {
        return i+1;
      }
    }
    throw new AOCException("Cannot solve it");
  }
}

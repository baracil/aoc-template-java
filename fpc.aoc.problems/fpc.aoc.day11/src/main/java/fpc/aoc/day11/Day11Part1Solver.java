package fpc.aoc.day11;

import fpc.aoc.api.AOCProblem;
import fpc.aoc.common.NotSolvedYet;
import lombok.NonNull;

import java.util.stream.Stream;

public class Day11Part1Solver extends Day11Solver {

  public static @NonNull AOCProblem<?> provider() {
    return new Day11Part1Solver().createProblem();
  }

  @Override
  public boolean isSkipped() {
    return true;
  }

  @Override
  public @NonNull String solve(@NonNull Stream<String> input) {
    throw new NotSolvedYet();
  }
}

package fpc.aoc.day1;

import fpc.aoc.api.AOCProblem;
import fpc.aoc.common.NotSolvedYet;
import lombok.NonNull;

import java.util.stream.Stream;

public class Day1Part2Solver extends Day1Solver {

  public static AOCProblem<?> provider() {
    return new Day1Part2Solver().createProblem();
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

package fpc.aoc.day3;

import fpc.aoc.api.AOCProblem;
import fpc.aoc.common.Displacement;
import lombok.NonNull;

import java.util.stream.Stream;

public class Day3Part2Solver extends Day3Solver {

  public static @NonNull AOCProblem<?> provider() {
    return new Day3Part2Solver().createProblem();
  }

  @Override
  public @NonNull Integer solve(@NonNull Stream<Displacement> input) {
    final var d = new DoubleDelivery();
    input.forEach(d::move);
    return d.getNbVisitedHouses();
  }

}

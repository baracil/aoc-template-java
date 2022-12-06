package fpc.aoc.day3;

import fpc.aoc.common.Displacement;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

import java.util.stream.Stream;

public abstract class Day3Solver extends SmartSolver<Stream<Displacement>, Integer> {

  @Override
  protected @NonNull Converter<Stream<Displacement>> getConverter() {
    return Converter.FIRST_LINE
        .andThen(s -> s.chars().mapToObj(DisplacementParser.INSTANCE::parse));
  }
}

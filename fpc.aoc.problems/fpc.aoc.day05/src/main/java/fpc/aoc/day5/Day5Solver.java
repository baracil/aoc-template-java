package fpc.aoc.day5;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@RequiredArgsConstructor
public abstract class Day5Solver extends SmartSolver<Stream<String>, String> {

  @Override
  protected @NonNull Converter<Stream<String>> getConverter() {
    return Converter.IDENTITY;
  }

}

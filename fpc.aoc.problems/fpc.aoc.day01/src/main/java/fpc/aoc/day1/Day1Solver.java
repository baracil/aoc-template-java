package fpc.aoc.day1;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Day1Solver extends SmartSolver<String, Integer> {

  @Override
  protected @NonNull Converter<String> getConverter() {
    return Converter.FIRST_LINE;
  }



}

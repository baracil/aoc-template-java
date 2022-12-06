package fpc.aoc.day3;

import fpc.aoc.common.AOCException;
import fpc.aoc.common.Displacement;
import lombok.NonNull;

public enum DisplacementParser {
  INSTANCE,;

  public @NonNull Displacement parse(int order) {
    return switch (order) {
      case '>' -> Displacement.W;
      case '<' -> Displacement.E;
      case '^' -> Displacement.N;
      case 'v' -> Displacement.S;
      default ->     throw new AOCException("Fail to parse displacement "+(char)order);
    };
  }
}

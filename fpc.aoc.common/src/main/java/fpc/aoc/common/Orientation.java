package fpc.aoc.common;

import lombok.NonNull;

import java.util.Map;

/**
 * Cardinal orientation
 */
public enum Orientation {
  N,
  E,
  S,
  W,
  ;

  public @NonNull Orientation turn(int angle) {
    final int a = Tools.mod(angle, 360);
    assert a == 0 || a == 90 || a == 180 || a == 270;
    return Holder.ROTATION.get(this)[a / 90];
  }

  private static final class Holder {

    private static final Map<Orientation, Orientation[]> ROTATION;

    static {
      ROTATION = Map.of(
        N, new Orientation[]{N, E, S, W},
        E, new Orientation[]{E, S, W, N},
        S, new Orientation[]{S, W, N, E},
        W, new Orientation[]{W, N, E, S}
      );
    }

  }
}

package fpc.aoc.day3;

import fpc.aoc.common.Bag;
import fpc.aoc.common.Displacement;
import fpc.aoc.common.Position;
import lombok.NonNull;

public class DoubleDelivery {

  private final @NonNull Bag<Position> visitedPosition;

  private final Position[] delivers = new Position[]{new Position(0,0), new Position(0,0)};
  private int turn =0;

  public DoubleDelivery() {
    this.visitedPosition = Bag.create();
    this.visitedPosition.addOne(delivers[0]);
  }

  public void move(@NonNull Displacement displacement) {
    final var d = delivers[turn].displaced(displacement);
    delivers[turn] = d;
    visitedPosition.addOne(d);
    turn = 1- turn;
  }

  public int getNbVisitedHouses() {
    return visitedPosition.nbKeys();
  }
}

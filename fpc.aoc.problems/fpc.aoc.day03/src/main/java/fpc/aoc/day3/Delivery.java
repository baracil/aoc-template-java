package fpc.aoc.day3;

import fpc.aoc.common.Bag;
import fpc.aoc.common.Displacement;
import fpc.aoc.common.Position;
import lombok.NonNull;

public class Delivery {

  private final @NonNull Bag<Position> visitedPosition;

  private Position current;

  public Delivery() {
    this.visitedPosition = Bag.create();
    this.current = new Position(0,0);
    this.visitedPosition.addOne(current);
  }

  public void move(@NonNull Displacement displacement) {
    current = current.displaced(displacement);
    visitedPosition.addOne(current);
  }

  public int getNbVisitedHouses() {
    return visitedPosition.nbKeys();
  }
}

package fpc.aoc.day1;

import lombok.Getter;

public class Lift {

  @Getter
  private int floor = 0;

  public void move(int order) {
    switch (order) {
      case '(' -> floor++;
      case ')' -> floor--;
    }
  }
}

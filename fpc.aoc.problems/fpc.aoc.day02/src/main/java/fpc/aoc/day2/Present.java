package fpc.aoc.day2;

import lombok.NonNull;

public record Present(int h, int w, int l) {

  public static @NonNull Present parse(@NonNull String line) {
    final var tokens = line.split("x", 3);
    return new Present(
        Integer.parseInt(tokens[0]),
        Integer.parseInt(tokens[1]),
        Integer.parseInt(tokens[2]));
  }

  public int smallestPerimeter() {
    return 2 * (h + w + l - Math.max(h, Math.max(w, l)));
  }

  public int smallestArea() {
    return Math.min(h*w, Math.min(h*l,l*w));
  }

  public int ribbonSize() {
    return h * w * l;
  }


  public int requiredRibbonLengthPart1() {
    return 2 * (h * w + h * l + w * l) +smallestArea();
  }

  public int requiredRibbonLengthPart2() {
    return smallestPerimeter() + ribbonSize();
  }

}

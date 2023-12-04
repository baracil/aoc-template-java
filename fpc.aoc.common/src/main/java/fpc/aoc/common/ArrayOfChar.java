package fpc.aoc.common;

import lombok.NonNull;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collector;

/**
 * @author Bastien Aracil
 **/
public interface ArrayOfChar extends Array, ArrayOfCharReader {


  static @NonNull ArrayOfChar from(@NonNull String data, char filling) {
    return Arrays.stream(data.split("\n"))
      .collect(ArrayOfChar.collector(filling));
  }

  static @NonNull ArrayOfChar from(@NonNull List<String> data, char filling) {
    return data.stream().collect(ArrayOfChar.collector(filling));
  }

  static @NonNull ArrayOfChar of(char[] data, char filling, int width, int height) {
    return new BaseArrayOfChar(data, filling, width, height);
  }

  @NonNull Transformation transformation();

  /**
   * @param position the seek position
   * @return the char at the provided position
   */
  char get(@NonNull Position position);

  /**
   * @return the char at x and y
   */
  char get(int x, int y);

  char filling();

  /**
   * Collect a stream of string to an array of char
   *
   * @param filling the char to use as a filling for positions outside the array
   * @return an {@link ArrayOfChar} built from the stream of string
   */
  @NonNull
  static Collector<String, ?, ArrayOfChar> collector(char filling) {
    return BaseArray.baseCollector(
      String::toCharArray,
      c -> c.length,
      char[]::new,
      a -> Arrays.fill(a, filling),
      (source, destination, destinationOffset) -> System.arraycopy(source, 0, destination, destinationOffset,
        source.length),
      (source, width, height) -> new BaseArrayOfChar(source, filling, width, height)


    );
  }

  @NonNull String asString();

  @NonNull ArrayOfChar rotate(@NonNull Rotation rotation);

  @NonNull ArrayOfChar flip(@NonNull Flipping flipping);

  default @NonNull String upperBorder() {
    return extract(i -> i, i -> 0, width());
  }

  default @NonNull String lowerBorder() {
    final int width = width();
    final int height = height();
    return extract(i -> width - 1 - i, i -> height - 1, width);
  }

  default @NonNull String leftBorder() {
    final int width = width();
    final int height = height();
    return extract(i -> 0, i -> height - 1 - i, height);
  }

  default @NonNull String rightBorder() {
    final int width = width();
    final int height = height();
    return extract(i -> width - 1, i -> i, height);
  }

  default @NonNull String extract(IntUnaryOperator xGetter, IntUnaryOperator yGetter, int length) {
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < length; i++) {
      final int x = xGetter.applyAsInt(i);
      final int y = yGetter.applyAsInt(i);
      sb.append(get(x, y));
    }
    return sb.toString();
  }

  @NonNull ArrayOfChar transform(@NonNull Transformation transformation);
}

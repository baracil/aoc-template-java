package fpc.aoc.day5;

import fpc.aoc.common.NotSolvedYet;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Word {

  private final @NonNull String value;

  public static @NonNull Word of(@NonNull String value) {
    return new Word(value);
  }

  public boolean isNicePart2() {
    throw new NotSolvedYet();
  }

  public boolean isNicePart1() {
    int nbVowels = 0;
    boolean has2InRow = false;
    char previous = 'a';

    for (int i = 0; i < value.length(); i++) {
      final var c = value.charAt(i);

      if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
        nbVowels++;
      }

      if (i == 0) {
        previous = c;
        continue;
      }

      if (previous == c) {
        has2InRow = true;
      }
      if (previous =='a' || previous == 'c' || previous == 'p' || previous == 'x') {
        if ((previous+1) == c) {
          return false;
        }
      }
      previous = c;
    }

    return nbVowels >= 3 && has2InRow;
  }

}

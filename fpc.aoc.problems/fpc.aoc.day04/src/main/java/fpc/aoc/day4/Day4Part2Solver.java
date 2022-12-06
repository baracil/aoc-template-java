package fpc.aoc.day4;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

public class Day4Part2Solver extends Day4Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day4Part2Solver().createProblem();
    }

    public Day4Part2Solver() {
        super();
    }

    @Override
    public boolean isAdventCoin(byte[] data) {
        return data[0] == 0 && data[1] == 0 && data[2] == 0;
    }
}

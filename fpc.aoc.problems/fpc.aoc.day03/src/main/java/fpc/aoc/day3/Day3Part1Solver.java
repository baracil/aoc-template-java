package fpc.aoc.day3;

import fpc.aoc.api.AOCProblem;
import fpc.aoc.common.Displacement;
import lombok.NonNull;

import java.util.stream.Stream;

public class Day3Part1Solver extends Day3Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day3Part1Solver().createProblem();
    }

    @Override
    public @NonNull Integer solve(@NonNull Stream<Displacement> input) {
        final var delivery = new Delivery();

        input.forEach(delivery::move);

        return delivery.getNbVisitedHouses();
    }
}

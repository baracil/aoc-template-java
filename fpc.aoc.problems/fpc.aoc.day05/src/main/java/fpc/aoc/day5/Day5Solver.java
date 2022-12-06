package fpc.aoc.day5;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.function.Predicate;
import java.util.stream.Stream;

@RequiredArgsConstructor
public abstract class Day5Solver extends SmartSolver<Stream<Word>,Long> {

    private final @NonNull Predicate<Word> niceTester;

    @Override
    protected @NonNull Converter<Stream<Word>> getConverter() {
        return s -> s.map(Word::of);
    }

    @Override
    public @NonNull Long solve(@NonNull Stream<Word> input) {
        return input.filter(niceTester).count();
    }
}

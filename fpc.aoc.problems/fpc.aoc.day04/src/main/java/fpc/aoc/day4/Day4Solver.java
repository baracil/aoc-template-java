package fpc.aoc.day4;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public abstract class Day4Solver extends SmartSolver<String,Integer> {

    @Override
    protected @NonNull Converter<String> getConverter() {
        return Converter.FIRST_LINE;
    }

    private final MessageDigest md5;

    public Day4Solver() {
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    @Override
    public @NonNull Integer solve(@NonNull String input) {
        for (int i = 0;; i++) {
            if (isAdventCoins(input,i)) {
                return i;
            }
        }
    }

    private boolean isAdventCoins(String header, int key) {
        final var d = computeMD5(header,key);
        return isAdventCoin(d);
    }

    private byte[] computeMD5(String header, int key) {
        md5.update((header+key).getBytes(StandardCharsets.US_ASCII));
        return md5.digest();
    }

    public abstract boolean isAdventCoin(byte[] data);

}

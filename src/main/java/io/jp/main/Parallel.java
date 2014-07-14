package io.jp.main;

import static io.jp.Helpers.printHeading;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Parallel {

    private static final IntPredicate EVEN = number -> number % 2 == 0;

    public static void main(String[] args) {

        printHeading("Filters and aggregates a large Integer stream in both parallel and serial");

        // Parallel
        long start = System.currentTimeMillis();
        IntStream.range(0, Integer.MAX_VALUE)
            .parallel()
            .filter(EVEN)
            .average();
        System.out.println(String.format("Parallel execution took %d ms", System.currentTimeMillis() - start));

        // Serial
        start = System.currentTimeMillis();
        IntStream.range(0, Integer.MAX_VALUE)
            .filter(EVEN)
            .average();
        System.out.println(String.format("Serial execution took %d ms", System.currentTimeMillis() - start));

    }
}

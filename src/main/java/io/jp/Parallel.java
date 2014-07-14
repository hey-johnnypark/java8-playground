package io.jp;

import java.util.stream.IntStream;

public class Parallel {

    public static void main(String[] args) {

        Helpers.printHeading("Filter and aggregate a large Integer stream in parallel and in serial");
        long start = System.currentTimeMillis();
        IntStream.range(0, Integer.MAX_VALUE)
            .parallel()
            .filter(number -> number % 2 == 0)
            .average();
        System.out.println(String.format("Parallel took %d ms", System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        IntStream.range(0, Integer.MAX_VALUE)
            .filter(number -> number % 2 == 0)
            .average();
        System.out.println(String.format("Serial took %d ms", System.currentTimeMillis() - start));
        
        
        
    }
}

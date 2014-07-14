package io.jp.main;

import static io.jp.Consumers.PRINT_FUNCTION_LAMBDA;
import static io.jp.Helpers.NAMES;
import io.jp.Helpers;
import io.jp.PrintFunction;

import java.io.IOException;

public class Lambda {

    public static void main(String[] args) throws IOException {

        Helpers.printHeading("Iterates over a list of String and prints out every entry (Old Way)");
        for (String name : NAMES) {
            System.out.println(name);
        }

        Helpers.printHeading("Iterates over a list of String and prints out every entry (New forEach() approach)");
        NAMES.forEach(new PrintFunction());

        Helpers
            .printHeading("Iterates over a list of String and prints out every entry (New forEach() with Lambda function)");
        NAMES.forEach(PRINT_FUNCTION_LAMBDA);

    }
}

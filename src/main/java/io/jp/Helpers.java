package io.jp;

import java.util.Arrays;
import java.util.Collection;
import java.util.TimeZone;
import java.util.stream.IntStream;

public class Helpers {

    public static final Collection<String> NAMES =
        Arrays.asList("Manuel", "Benedikt", "Jerome", "Matts", "Philipp", "Toni", "Christoph", "Sebastian", "Thomas",
            "Miroslav", "Mesut");

    public static final Collection<String> TIME_ZONES = Arrays.asList(TimeZone.getAvailableIDs());

    public static final Collection<Person> PERSONS = Arrays.asList(
        new Person("Max", "Mustermann"),
        new Person("Peter", "Funke"),
        new Person("Max", "Hinterseer"),
        new Person("Peter", "Krause"),
        new Person("Andreas", "Möller")
        );

    public static final Collection<Integer> NUMBERS =
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

    public static void printHeading(String heading) {
        System.out.println(heading);
        IntStream.range(0, heading.length()).forEach(i -> System.out.print("#"));
        System.out.println();
    }

}

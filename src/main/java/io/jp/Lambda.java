package io.jp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.stream.Collectors;
import static io.jp.Helpers.printHeading;

public class Lambda {

    private static final Collection<String> NAMES =
        Arrays.asList("Peter", "Andi", "Sebastian", "Claus Kleber", "Andreas", "Andi", "Peter");

    private static final Collection<String> TIME_ZONES = Arrays.asList(TimeZone.getAvailableIDs());

    private static final Collection<Person> PERSONS = Arrays.asList(
        new Person("Max", "Mustermann"),
        new Person("Peter", "Funke"),
        new Person("Max", "Hinterseer"),
        new Person("Peter", "Krause"),
        new Person("Andreas", "Möller")
        );

    private static final Collection<Integer> NUMBERS =
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

    public static void main(String[] args) throws IOException {

        printHeading("Filter long and print out long names (length > 5)");
        NAMES.stream().filter(Predicates.LONG_NAMES).forEach(System.out::println);

        printHeading("Filter and count long names (length > 5)");
        System.out.println(NAMES.stream().filter(Predicates.LONG_NAMES).count());

        printHeading("Filter and print out even numbers");
        NUMBERS.stream().filter(Predicates.EVEN).forEach(System.out::println);

        printHeading("Filter and multiply even numbers with theirself");
        NUMBERS.stream().filter(Predicates.EVEN).mapToInt((i) -> (i * i)).forEach(System.out::println);

        printHeading("Filter even numbers and apply reduce algorithm");
        System.out.println("Reduce result: " + NUMBERS.stream().filter(Predicates.EVEN).reduce((a, b) -> {
            System.out.println(a + " + " + b + " = " + (a + b));
            return a + b;
        }).get());

        printHeading("Filter even numbers and apply reduce algorithm staring with 100");
        System.out.println("Reduce result: " + NUMBERS.stream().filter(Predicates.EVEN).reduce(100, (a, b) -> a + b));

        printHeading("Collect and map persons with same firstname");
        Map<String, List<Person>> personsByFirstName = PERSONS.stream().collect(
            Collectors.groupingBy(Person::getFirstName));
        System.out.println(personsByFirstName);

        printHeading("Collect and aggregate available timezones for each region");
        System.out.println(TIME_ZONES.stream()
            .filter(zone -> (zone.contains("/")))
            .collect(Collectors.groupingBy(zone -> zone.substring(0, zone.indexOf("/")), Collectors.counting())));

        printHeading("Partition time zones containing '/' and those which don't");
        System.out.println(TIME_ZONES.stream()
            .collect(Collectors.partitioningBy(Predicates.ZONE_CONTAINING_SLASH)));

        printHeading("Join entries of a list with , (comma)");
        System.out.println(NAMES.stream().collect(Collectors.joining(",")));

        printHeading("Collect elements matching a filter into a new collection");
        System.out.println(PERSONS.stream()
            .filter(person -> person.getFirstName().startsWith("M"))
            .collect(Collectors.toList()));

        printHeading("Handle a file as a stream. Prints out distinct cities people are living in");
        Files.lines(Paths.get("src/main/resources/foobar.txt"))
            .map(line -> line.split("[,]")[1].trim())
            .distinct()
            .forEach(System.out::println);

        printHeading("Creates a stream from int array and sums up all containing elements");
        System.out.println(Arrays.stream(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }).sum());

    }
}

package io.jp;

import java.util.function.Predicate;

public class Predicates {

    public static final Predicate<String> ZONE_CONTAINING_SLASH = zone -> zone.contains("/");

    public static final Predicate<String> LONG_NAMES = name -> name.length() > 5;

    public static final Predicate<Integer> EVEN = number -> number % 2 == 0;

}
